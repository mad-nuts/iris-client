package iris.client_bff.events;

import iris.client_bff.core.AggregateRepository;
import iris.client_bff.events.model.EventDataSubmission;
import iris.client_bff.events.model.EventDataSubmission.DataSubmissionIdentifier;

import javax.transaction.Transactional;

import org.springframework.data.util.Streamable;

/**
 * @author Jens Kutzsche
 */
public interface EventDataSubmissionRepository
		extends AggregateRepository<EventDataSubmission, DataSubmissionIdentifier> {

	@Transactional
	Streamable<EventDataSubmission> findAllByRequest(EventDataRequest request);

	@Transactional
	void deleteAllByRequestIn(Iterable<? extends EventDataRequest> requests);
}
