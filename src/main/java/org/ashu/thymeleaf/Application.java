package org.ashu.thymeleaf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication 
@EnableAutoConfiguration
@ComponentScan(basePackages = {"org.ashu.thymeleaf","org.openapitools", "org.ashu.thymeleaf.api" , "org.ashu.thymeleaf.config", "org.ashu.schema.validation","org.ashu.validation"})
@EntityScan(basePackages= {"org.ashu.thymeleaf","org.openapitools", "org.ashu.thymeleaf.api" , "org.ashu.thymeleaf.config", "org.ashu.schema.validation","org.ashu.validation"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
 
   
}
