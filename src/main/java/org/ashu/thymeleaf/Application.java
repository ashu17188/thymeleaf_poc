package org.ashu.thymeleaf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.templatemode.TemplateMode;

@SpringBootApplication 
@EnableAutoConfiguration
@ComponentScan(basePackages={"org.ashu.thymeleaf"})
@EntityScan(basePackages="org.ashu.thymeleaf")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
 
   
}
