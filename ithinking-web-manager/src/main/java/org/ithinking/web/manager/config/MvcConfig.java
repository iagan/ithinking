package org.ithinking.web.manager.config;

import org.apache.log4j.Logger;
import org.ithinking.spring.tengine.TengineViewResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {

	private static final Logger logger = Logger  
            .getLogger(MvcConfig.class);  
	
	
	@Bean  
    public ViewResolver viewResolver() {  
		
        logger.info("ViewResolver");  
        /*
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();  
        viewResolver.setPrefix("/WEB-INF/views/jsp/function/");  
        viewResolver.setSuffix(".jsp");  
        return viewResolver;  */
        
        TengineViewResolver viewResolver = new TengineViewResolver();  
        viewResolver.setPrefix("/WEB-INF/views/");  
        viewResolver.setSuffix(".html");  
        return viewResolver;  
        
        
        
        
      
    }  
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		//registry.addResourceHandler("/**").addResourceLocations("/");
		//registry.addResourceHandler("/**").addResourceLocations("/WEB-INF/views/");
		registry.addResourceHandler("/**").addResourceLocations("/");
	}
	
	
}
