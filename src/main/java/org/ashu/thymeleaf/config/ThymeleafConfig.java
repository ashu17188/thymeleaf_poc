package org.ashu.thymeleaf.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.templateresolver.StringTemplateResolver;

@Configuration
public class ThymeleafConfig {

	/*
	 * @Bean(name = "textTemplateEngine") public TemplateEngine textTemplateEngine()
	 * { TemplateEngine templateEngine = new TemplateEngine();
	 * templateEngine.addTemplateResolver(textTemplateResolver()); return
	 * templateEngine; }
	 * 
	 * private ITemplateResolver textTemplateResolver() {
	 * ClassLoaderTemplateResolver templateResolver = new
	 * ClassLoaderTemplateResolver();
	 * templateResolver.setPrefix("/templates/text/");
	 * templateResolver.setSuffix(".txt");
	 * templateResolver.setTemplateMode(TemplateMode.TEXT);
	 * templateResolver.setCharacterEncoding("UTF8");
	 * templateResolver.setCheckExistence(true);
	 * templateResolver.setCacheable(false); return templateResolver; }
	 */

	private static final String UTF8 = "UTF-8";

	@Bean
	public StringTemplateResolver stringTemplateResolver() {
		return new StringTemplateResolver();
	}

}
