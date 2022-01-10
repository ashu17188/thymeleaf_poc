package org.ashu.thymeleaf.validation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.atlassian.oai.validator.model.NormalisedPath;
import com.atlassian.oai.validator.model.NormalisedPathImpl;

@Service
public class PolicyMandatory implements MandatoryJsonPathSupplier {

	public static final String PET_POST = "pet";

	@Value("${server.servlet.context-path}")
	private String basePath;

	@Autowired
	private JsonPaths jsonPaths;

	@Override
	public List<NormalisedPath> getApiPath() {
		return List.of(new NormalisedPathImpl(PET_POST, basePath));
	}

	@Override
	public List<String> getJsonPaths() {
		return jsonPaths.getPaths();
	}

}
