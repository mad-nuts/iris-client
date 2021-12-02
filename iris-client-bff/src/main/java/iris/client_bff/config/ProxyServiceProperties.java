package iris.client_bff.config;

import lombok.Value;

import javax.validation.constraints.NotBlank;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.validation.annotation.Validated;

@ConfigurationProperties("proxy-service")
@ConstructorBinding
@Value
@Validated
public class ProxyServiceProperties {

	private final String epsName;
	private final String targetProxy;

	@NotBlank
	private final String targetSubdomain;
}
