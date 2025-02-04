/*******************************************************************************
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. If not, see <https://www.gnu.org/licenses/>.
 *******************************************************************************/
package iris.client_bff.cases;

import io.vavr.control.Try;
import iris.client_bff.core.mail.EmailProvider;
import iris.client_bff.core.mail.EmailSender;
import iris.client_bff.core.mail.EmailSender.TemplatedEmail.ConfiguredRecipient;
import iris.client_bff.core.mail.EmailTemplates;
import iris.client_bff.core.model.EmailAddress;
import lombok.AccessLevel;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

/**
 * Helper to send out emails during index case processing
 *
 * @author Jens Kutzsche
 */
@Component
public class CaseEmailProvider extends EmailProvider {

	@Value("${iris.client.basePath}")
	private String basePath;

	@Value("${iris.client.mailing.active:false}")
	private @Setter(value = AccessLevel.PACKAGE) boolean mailingActive;

	@Value("${spring.mail.properties.recipient.case.data-received.name:#{null}}")
	private String dataReceivedRecipientName;
	@Value("${spring.mail.properties.recipient.case.data-received.email:#{null}}")
	private @Setter(value = AccessLevel.PACKAGE) String dataReceivedRecipientEmail;

	public CaseEmailProvider(EmailSender emailSender, MessageSourceAccessor messages, MailProperties mailProperties) {
		super(emailSender, messages, mailProperties);
	}

	@PostConstruct
	void checkMailProperties() {

		if (mailingActive) {
			Assert.isTrue(EmailAddress.isValid(dataReceivedRecipientEmail),
					"The property spring.mail.properties.recipient.case.data-received.email must contains the e-mail address of the recipient for case hints!");
		}
	}

	@Async
	public Future<Try<Void>> sendDataReceivedEmailAsynchronously(CaseDataRequest caseData) {

		if (!mailingActive) {
			return AsyncResult.forValue(Try.success(null));
		}

		Map<String, Object> parameters = new HashMap<>();
		parameters.put("caseId", caseData.getName());
		parameters.put("externalId", caseData.getRefId());
		parameters.put("startTime", caseData.getRequestStart());
		parameters.put("endTime", caseData.getRequestEnd());
		parameters.put("caseUrl", basePath + "/cases/details/" + caseData.getId());

		var subject = messages.getMessage("CaseDataReceivedEmail.subject");

		EmailAddress emailAddress = EmailAddress.of(dataReceivedRecipientEmail);
		ConfiguredRecipient recipient = new ConfiguredRecipient(dataReceivedRecipientName, emailAddress);

		CaseEmail email = new CaseEmail(recipient, subject, EmailTemplates.Keys.CASE_DATA_RECEIVED_MAIL_FTLH, parameters);
		return new AsyncResult<>(sendMail(email, parameters.get("caseId").toString()));
	}
}
