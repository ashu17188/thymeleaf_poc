package org.ashu.thymeleaf.config;

import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.json.XML;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.expression.spel.support.StandardTypeLocator;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.thymeleaf.context.Context;
import org.thymeleaf.context.IContext;
import org.thymeleaf.spring5.expression.ThymeleafEvaluationContext;
import org.thymeleaf.spring5.expression.ThymeleafEvaluationContextWrapper;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class ContextCreatorImpl extends ContextCreator {

	public ContextCreatorImpl(ObjectMapper mapper) {
		super(mapper);
	}

	IContext createThymeleafContext(Map<String, Object> contextVariables) {
		Context context = (Context) super.createThymeleafContext(contextVariables);
		StandardEvaluationContext delegate = new StandardEvaluationContext();
		StandardTypeLocator tl = new StandardTypeLocator(ContextCreatorImpl.class.getClassLoader());
		delegate.setTypeLocator(tl);
		EvaluationContext evaluationContext = new ThymeleafEvaluationContextWrapper(delegate);
		context.setVariable(ThymeleafEvaluationContext.THYMELEAF_EVALUATION_CONTEXT_CONTEXT_VARIABLE_NAME,
				evaluationContext);
		return context;
	}
}
