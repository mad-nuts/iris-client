package iris.client_bff.core.web.error;

import static java.util.stream.Collectors.*;

import java.util.List;
import java.util.Map;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.apache.commons.lang3.BooleanUtils;
import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.boot.autoconfigure.web.ErrorProperties.IncludeAttribute;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.error.ErrorAttributeOptions.Include;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.context.request.WebRequest;

/**
 * @author Jens Kutzsche
 */
@Component
public class IrisErrorAttributes extends DefaultErrorAttributes {

	private static final String ERRORS_KEY = "errors";

	private final ErrorProperties errorProperties;

	public IrisErrorAttributes(ServerProperties serverProperties) {
		this.errorProperties = serverProperties.getError();
	}

	public Map<String, Object> getErrorAttributes(WebRequest request) {
		return getErrorAttributes(request, getErrorAttributeOptions(request));
	}

	@Override
	public Map<String, Object> getErrorAttributes(WebRequest webRequest, ErrorAttributeOptions options) {

		var errorAttributes = super.getErrorAttributes(webRequest, options);

		Throwable error = getError(webRequest);
		if (error != null) {

			if (error instanceof Errors br) {
				setErrorAttribute(errorAttributes, mapErrors(br));
			} else if (error instanceof ConstraintViolationException cve) {
				setErrorAttribute(errorAttributes, mapViolations(cve));
			}
		}

		if (!options.isIncluded(Include.BINDING_ERRORS)) {
			errorAttributes.remove(ERRORS_KEY);
		}

		return errorAttributes;
	}

	private Map<String, List<ObjectError>> mapErrors(Errors br) {
		return br.getAllErrors().stream().collect(groupingBy(this::mapError));
	}

	private String mapError(ObjectError error) {

		var name = error.getObjectName();

		if (error instanceof FieldError fe) {
			name = fe.getField();
		}

		return name;
	}

	private Map<String, List<String>> mapViolations(ConstraintViolationException cve) {

		return cve.getConstraintViolations().stream()
				.collect(groupingBy(it -> it.getPropertyPath().toString(),
						mapping(ConstraintViolation::getMessage, toList())));
	}

	private Object setErrorAttribute(Map<String, Object> errorAttributes, Object content) {
		return errorAttributes.put(ERRORS_KEY, content);
	}

	private ErrorAttributeOptions getErrorAttributeOptions(WebRequest request) {

		var options = ErrorAttributeOptions.defaults();

		if (this.errorProperties.isIncludeException()) {
			options = options.including(Include.EXCEPTION);
		}
		if (isIncludeAttribute(errorProperties.getIncludeStacktrace(), request, "trace")) {
			options = options.including(Include.STACK_TRACE);
		}
		if (isIncludeAttribute(errorProperties.getIncludeMessage(), request, "message")) {
			options = options.including(Include.MESSAGE);
		}
		if (isIncludeAttribute(errorProperties.getIncludeBindingErrors(), request, ERRORS_KEY)) {
			options = options.including(Include.BINDING_ERRORS);
		}
		return options;
	}

	private boolean isIncludeAttribute(IncludeAttribute attribute, WebRequest request, String parameterName) {

		switch (attribute) {
			case ALWAYS:
				return true;
			case ON_PARAM:
				return BooleanUtils.toBoolean(request.getParameter(parameterName));
			default:
				return false;
		}
	}
}
