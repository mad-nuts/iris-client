package iris.client_bff.iris_messages;

import iris.client_bff.core.Aggregate;
import iris.client_bff.core.IdWithUuid;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.io.Serial;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.*;

import org.hibernate.search.engine.backend.types.Sortable;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.FullTextField;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.GenericField;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.Indexed;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.IndexedEmbedded;

@Entity
@Table(name = "iris_message")
@Indexed
@Data
@EqualsAndHashCode(callSuper = true, exclude = "folder")
@NoArgsConstructor
public class IrisMessage extends Aggregate<IrisMessage, IrisMessage.IrisMessageIdentifier> {

	public static final int SUBJECT_MAX_LENGTH = 500;
	public static final int BODY_MAX_LENGTH = 6000;

	{
		id = IrisMessage.IrisMessageIdentifier.of(UUID.randomUUID());
	}

	@ManyToOne
	@JoinColumn(name = "folder_id", nullable = false)
	@IndexedEmbedded(includeEmbeddedObjectId = true)
	private IrisMessageFolder folder;

	@Column(nullable = false)
	@FullTextField(name = "subject_search", analyzer = "german")
	@GenericField(sortable = Sortable.YES)
	private String subject;

	@Column(nullable = false)
	private String body;

	@Column(nullable = false)
	@Embedded
	@IndexedEmbedded
	@AttributeOverrides({
			@AttributeOverride(name = "id", column = @Column(name = "hd_author_id")),
			@AttributeOverride(name = "name", column = @Column(name = "hd_author_name"))
	})
	private IrisMessageHdContact hdAuthor;

	@Column(nullable = false)
	@Embedded
	@IndexedEmbedded
	@AttributeOverrides({
			@AttributeOverride(name = "id", column = @Column(name = "hd_recipient_id")),
			@AttributeOverride(name = "name", column = @Column(name = "hd_recipient_name"))
	})
	private IrisMessageHdContact hdRecipient;

	private boolean isRead;

	@OneToMany(mappedBy = "message", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	private List<IrisMessageData> dataAttachments = new ArrayList<>();

	@EqualsAndHashCode(callSuper = false)
	@RequiredArgsConstructor(staticName = "of")
	@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE) // for JPA
	public static class IrisMessageIdentifier extends IdWithUuid {

		@Serial
		private static final long serialVersionUID = -8204204051601543710L;

		private final UUID id;

		@Override
		protected UUID getBasicId() {
			return id;
		}
	}
}
