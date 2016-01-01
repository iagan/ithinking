package org.ithinking.web.manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

@SpringBootApplication 
// @Configuration,@EnableAutoConfiguration,@ComponentScan, @EnableWebMvc(自动检查)
public class Application extends SpringBootServletInitializer{

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }
}
