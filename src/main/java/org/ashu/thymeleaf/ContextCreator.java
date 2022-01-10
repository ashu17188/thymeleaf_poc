package org.ashu.thymeleaf;

import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.json.XML;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.thymeleaf.context.Context;
import org.thymeleaf.context.IContext;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class ContextCreator {

	private final ObjectMapper mapper;

	public ContextCreator(ObjectMapper mapper) {
		this.mapper = mapper;
	}

	IContext createThymeleafContext(Map<String, Object> contextVariables) {
		Context context = new Context();
		if (!CollectionUtils.isEmpty(contextVariables)) {
			contextVariables.forEach((variableName, value) -> {
				if (value instanceof String) {
					context.setVariable(variableName, this.jsonToObject(value.toString()));
				} else {
					context.setVariable(variableName, value);
				}
			});

		}
		return context;
	}

	private Object jsonToObject(String input) {
		try {
			return this.mapper.readValue(input, Map.class);
		} catch (Exception e) {
			try {
				return this.mapper.readValue(input, List.class);
			} catch (Exception e3) {
				return input;
			}
		}
	}

	public Object xmlOrJsonToObject(String input) {
		try {
			if (this.isValidJson(input)) {
				return this.jsonToObject(input);
			} else {
				JSONObject jsonObject = XML.toJSONObject(input);
				return jsonObject.length() == 0 ? input : jsonObject;
			}
		} catch (Exception e) {
			return input;
		}
	}

	public boolean isValidJson(String input) {
		try {
			this.mapper.readTree(input);
			return true;

		} catch (Exception e) {
			return false;
		}
	}
}
