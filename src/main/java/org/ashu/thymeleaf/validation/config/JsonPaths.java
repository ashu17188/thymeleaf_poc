package org.ashu.thymeleaf.validation.config;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("json-paths.mandatory")
public class JsonPaths {

	private List<String> policy;

	public List<String> getPolicy() {
		return policy;
	}

	public void setPolicy(List<String> policy) {
		this.policy = policy;
	}

}
