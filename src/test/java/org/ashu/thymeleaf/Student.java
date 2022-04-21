package org.ashu.thymeleaf;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@Getter
@Setter
public class Student {

	private long id;
	private String name;
	private int height;
	
	
	
}
