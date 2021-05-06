package org.ashu.thymeleaf;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templateresolver.StringTemplateResolver;

@RequestMapping("/api/test")
@RestController
public class ThymeleafController {

	@Autowired
	private TemplateProcessor templateProcessor;

	public ThymeleafController() {
	}

	public ThymeleafController(TemplateProcessor templateProcessor) {
		this.templateProcessor = templateProcessor;
	}

	@GetMapping(value = "/sample", produces = MediaType.APPLICATION_JSON_VALUE)
	public String getSample() {

		Map<String, Object> params = new HashMap<>();

		params.put("name", "Ashutosh");
		params.put("createdDate", LocalDateTime.now());
//		params.put("url", "http://spring.io");
//		params.put("tags", "#framework #java #spring".split(" "));
		
		String response = this.templateProcessor.processTemplate(params, "request");
		return response;
	}

//	public static String render(String template, Map<String, Object> params) {
//		Context context = new Context();
//		context.setVariables(params);
//		TemplateEngine engine = new TemplateEngine();
//
//		StringTemplateResolver resolver = new StringTemplateResolver();
//		engine.setTemplateResolver(resolver);
//		return engine.process(template, context);
//	}

}
