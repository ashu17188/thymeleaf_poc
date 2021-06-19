package org.ashu.thymeleaf.service;

import java.util.HashMap;
import java.util.Map;

import org.ashu.thymeleaf.TemplateProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PostServiceImpl implements PostService {

//	@Autowired
//	private RestTemplate restTemplate;
	
	@Autowired
	private TemplateProcessor templateProcessor;

	
	private static final String POSTS_URL= "https://jsonplaceholder.typicode.com/posts";
	
	public String getPosts() {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.getForEntity(POSTS_URL, String.class);
		response.getBody();
		
		Map<String, Object> params = new HashMap<>();
		params.put("response", response.getBody());
		
		String modifiedResponse = this.templateProcessor.processTemplate(params, "postResponse");
		return modifiedResponse;
	}
	
}
