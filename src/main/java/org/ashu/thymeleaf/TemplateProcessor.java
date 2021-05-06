package org.ashu.thymeleaf;

import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Component;
import org.thymeleaf.ITemplateEngine;
import org.thymeleaf.TemplateSpec;
import org.thymeleaf.context.IContext;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;

@Component
public class TemplateProcessor {

	private ContextCreator contextCreator;
	
	private ITemplateEngine templateEngine;
	private TemplateReader templateReader;

	public TemplateProcessor(ContextCreator contextCreator, ITemplateEngine templateEngine,
			TemplateReader templateReader) {
		this.contextCreator = contextCreator;
		this.templateEngine = templateEngine;
		this.templateReader = templateReader;
	}

	public String processTemplate(Map<String, Object> contextVariables, String templateName) {
		try {
			String template = this.templateReader.readTemplate(templateName);
			IContext context = this.contextCreator.createThymeleafContext(contextVariables);
			TemplateSpec templateSpec = new TemplateSpec(template, TemplateMode.JAVASCRIPT);
			Set<ITemplateResolver> resolverList = this.templateEngine.getConfiguration().getTemplateResolvers();
//	        this.templateEngine.addTemplateResolver(new StringTemplateResolver());

			String processedRequest = this.templateEngine.process(templateSpec, context);
			String regEx = String.format("[%S]", System.lineSeparator());
			return processedRequest.replaceAll(regEx, "");

		} catch (Exception var2) {
			throw new RuntimeException("Template exception occurred");
		}
	}
}
