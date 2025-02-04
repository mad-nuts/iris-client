package iris.client_bff.core.mail;

import io.vavr.control.Try;
import iris.client_bff.core.mail.EmailTemplates.EmailType;
import iris.client_bff.core.mail.EmailTemplates.Key;
import iris.client_bff.core.model.EmailAddress;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.Instant;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.util.Assert;

/**
 * @author Jens Kutzsche
 */
public interface EmailSender {

	String MISSING_FIXED_SENDER = "A fixed sender must be set using the \"spring.mail.properties.fix-sender\" property.";
	String FIX_SENDER_PROPERTY_KEY = "fix-sender";

	/**
	 * Verifies the connection to the actual email server.
	 *
	 * @return an {@link Object} to represent the server information, will never be {@literal null}.
	 */
	Try<Object> testConnection();

	/**
	 * Sends the given {@link TemplatedEmail}.
	 *
	 * @param email must not be {@literal null}.
	 * @return
	 */
	Try<Void> sendMail(TemplatedEmail email);

	/**
	 * An email to be composed from {@link EmailTemplates} and {@link CoreProperties}. Custom implementations usually
	 * extend {@link AbstractTemplatedEmail}.
	 *
	 * @author Jens Kutzsche
	 * @author Oliver Drotbohm
	 * @see AbstractTemplatedEmail
	 */
	public interface TemplatedEmail {

		Key getTemplate();

		/**
		 * Composes a {@link SimpleMailMessage} using the given {@link EmailTemplates} and {@link CoreProperties}.
		 *
		 * @param templates must not be {@literal null}.
		 * @param configuration must not be {@literal null}.
		 * @param mailProperties
		 * @param environment
		 * @return
		 */
		SimpleMailMessage toSimpleMail(EmailTemplates templates, MailProperties mailProperties);

		/**
		 * Composes a {@link MimeMailMessage} using the given {@link EmailTemplates} and {@link CoreProperties}.
		 *
		 * @param templates must not be {@literal null}.
		 * @param configuration must not be {@literal null}.
		 * @param mailProperties
		 * @param internalSender
		 * @param environment
		 * @return
		 */
		MimeMessage toHmtlMail(EmailTemplates templates, MailProperties mailProperties,
				@NonNull JavaMailSenderImpl internalSender)
				throws MessagingException;

		EmailType toMailType(EmailTemplates templates);

		Recipient getFinalRecipient(MailProperties mailProperties);

		interface InternetAdressSource {

			String ADRESS_FORMAT = "%s <%s>";

			String getFullName();

			EmailAddress getEmailAddress();

			default String toInternetAddress() {

				var fullName = StringUtils.defaultString(getFullName());

				return String.format(ADRESS_FORMAT, fullName, getEmailAddress());
			}
		}

		public interface Sender extends InternetAdressSource {}

		public interface Recipient extends InternetAdressSource {}

		@RequiredArgsConstructor
		public static class ConfiguredRecipient implements Recipient {

			private final @Getter String fullName;
			private final @Getter EmailAddress emailAddress;
		}
	}

	/**
	 * Convenient base class to compose emails from a template defined by a {@link Key} and placeholders to expand the
	 * template with. Sender and Receiver are abstracted to be composed separately and handed into the instance.
	 *
	 * @author Jens Kutzsche
	 * @author Oliver Drotbohm
	 */
	@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
	@Slf4j
	public abstract static class AbstractTemplatedEmail implements TemplatedEmail {

		/**
		 * At the moment we can only use a configured fix sender address, to avoid problems with permissions. This comes
		 * from spam protection. With other sender addresses we get the following error:
		 * <code>550 5.7.60 SMTP; Client does not
		 * have permissions to send as this sender</code>. To configure the fix sender address use
		 * <code>spring.mail.properties.fix-sender</code>.
		 */
		private static final String FIX_SENDER_NAME_PROPERTY_KEY = "fix-sender-name";
		private static final String FIX_RECIPIENT_PROPERTY_KEY = "fix-recipient";
		private static final String IRIS_DOMAIN = "@iris-connect.de";
		private static final String IRIS_DOMAIN2 = "@iris-gateway.de";

		private final @Getter Recipient to;
		private final @Getter String subject;
		private final @Getter Key template;
		private final @Getter Map<String, ? extends Object> placeholders;
		private final Locale locale;

		@Override
		public SimpleMailMessage toSimpleMail(EmailTemplates templates, @NonNull MailProperties mailProperties) {

			var message = new SimpleMailMessage();
			message.setFrom(determineSender(mailProperties));
			message.setTo(determineReceipient(mailProperties));
			message.setSubject(subject);
			message.setText(getBody(templates));
			message.setSentDate(Date.from(Instant.now()));

			if (log.isDebugEnabled()) {
				log.debug("Mail message created: " + message.toString());
			}

			return message;
		}

		@Override
		public MimeMessage toHmtlMail(EmailTemplates templates, @NonNull MailProperties mailProperties,
				@NonNull JavaMailSenderImpl internalSender)
				throws MessagingException {

			MimeMessage message = internalSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

			helper.setFrom(determineSender(mailProperties));
			helper.setTo(determineReceipient(mailProperties));
			helper.setSubject(subject);
			helper.setText(getBody(templates), true);
			helper.setSentDate(Date.from(Instant.now()));

			if (log.isDebugEnabled()) {
				log.debug("Mail message created: " + message.toString());
			}

			return message;
		}

		@Override
		public EmailType toMailType(EmailTemplates templates) {
			return templates.getTemplateType(template, locale);
		}

		@Override
		public Recipient getFinalRecipient(@NonNull MailProperties mailProperties) {

			var fixRecipient = mailProperties.getProperties().get(FIX_RECIPIENT_PROPERTY_KEY);

			return StringUtils.isBlank(fixRecipient)
					|| this.to.getEmailAddress().endsWith(IRIS_DOMAIN)
					|| this.to.getEmailAddress().endsWith(IRIS_DOMAIN2)
							? to
							: FixedConfiguredRecipient.of(EmailAddress.of(fixRecipient.trim()), to);
		}

		private String determineSender(MailProperties mailProperties) {
			return FixedConfiguredSender.of(mailProperties).toInternetAddress();
		}

		private String determineReceipient(@NonNull MailProperties mailProperties) {
			return getFinalRecipient(mailProperties).toInternetAddress();
		}

		private String getBody(EmailTemplates templates) {
			return templates.expandTemplate(template, locale, placeholders);
		}

		@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
		static class FixedConfiguredSender implements Sender {

			private final @Getter String fullName;
			private final @Getter EmailAddress emailAddress;

			public static FixedConfiguredSender of(MailProperties mailProperties) {

				var properties = mailProperties.getProperties();
				var fixSender = properties.get(FIX_SENDER_PROPERTY_KEY);
				var fixSenderName = properties.get(FIX_SENDER_NAME_PROPERTY_KEY);

				Assert.hasLength(fixSender, MISSING_FIXED_SENDER);

				var fullName = StringUtils.defaultString(fixSenderName).trim();
				var emailAddress = EmailAddress.of(fixSender.trim());

				return new FixedConfiguredSender(fullName, emailAddress);
			}
		}

		@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
		static class FixedConfiguredRecipient implements Recipient {

			private final @Getter String fullName;
			private final @Getter EmailAddress emailAddress;

			public static FixedConfiguredRecipient of(EmailAddress fixRecipient, Recipient originRecipient) {

				var fullName = originRecipient.getFullName() + " - "
						+ originRecipient.getEmailAddress().toString().replace("@", " {at} ");

				return new FixedConfiguredRecipient(fullName, fixRecipient);
			}
		}
	}
}
