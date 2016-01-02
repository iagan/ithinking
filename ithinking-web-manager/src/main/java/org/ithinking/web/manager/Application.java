package org.ithinking.web.manager;

import java.util.ArrayList;
import java.util.Collection;

import org.ithinking.web.manager.filter.LoginFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;

@SpringBootApplication
// @Configuration,@EnableAutoConfiguration,@ComponentScan, @EnableWebMvc(自动检查)
public class Application extends SpringBootServletInitializer {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Application.class);
	}

	/**
	 * 注册登录过滤Filter
	 * 
	 * @return
	 */
	@Bean
	public FilterRegistrationBean loinFilter() {
		FilterRegistrationBean filterRegBean = new FilterRegistrationBean();
		filterRegBean.setFilter(new LoginFilter());
		Collection<String> urlPatterns = new ArrayList<String>();
		urlPatterns.add("/**");
		filterRegBean.setUrlPatterns(urlPatterns);
		filterRegBean.setOrder(Ordered.HIGHEST_PRECEDENCE + 1);
		return filterRegBean;
	}
}
