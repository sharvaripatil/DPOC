package com.a4tech.shipping.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;

@Component
//@EnableWebMvc
public class WebConfig /*extends WebMvcConfigurerAdapter*/{
	
	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource resource = new ResourceBundleMessageSource();
		resource.setBasename("errorMessage");
		return resource;
	}
}
