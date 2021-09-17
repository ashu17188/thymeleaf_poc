package org.ashu.thymeleaf.validation.jsonpath;

import java.util.List;

import org.ashu.schema.validation.jsonpath.mandatory.MandatoryJsonPathSupplier;
import org.ashu.thymeleaf.validation.config.JsonPaths;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.atlassian.oai.validator.model.NormalisedPath;
import com.atlassian.oai.validator.model.NormalisedPathImpl;

@Component
public class PolicyMandatory implements MandatoryJsonPathSupplier {

	public static final String POLICIES_POST = "policies";

	@Value("${server.servlet.context-path}")
	private String basePath;

	@Autowired
	private JsonPaths jsonPaths;

	@Override
	public List<NormalisedPath> getApiPath() {
		return List.of(new NormalisedPathImpl(POLICIES_POST, basePath));
	}

	@Override
	public List<String> getJsonPaths() {
		return jsonPaths.getPolicy();
	}

}
