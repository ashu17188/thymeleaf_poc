package org.ashu.thymeleaf;

import java.awt.PageAttributes.MediaType;

import org.ashu.thymeleaf.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/posts")
public class PostController {

	
	@Autowired
	private PostService postService;

	
	@GetMapping(produces= org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getPosts(){
		return new ResponseEntity<>(postService.getPosts(),HttpStatus.OK);
	}
}
