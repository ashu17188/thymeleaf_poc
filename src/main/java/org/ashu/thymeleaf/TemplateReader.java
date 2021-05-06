package org.ashu.thymeleaf;

import java.io.IOException;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;

@Component
public class TemplateReader {

	public TemplateReader(){}

	public String readTemplate(String templateName) throws IOException {
		ClassPathResource resource =  new ClassPathResource("templates/"+ templateName);
		byte[] content = FileCopyUtils.copyToByteArray(resource.getInputStream());
				return new String(content);
		}


}
