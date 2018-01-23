package com.mykala.consumer.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.mykala.consumer.api.repository.CascadingMongoEventListener;

@Configuration
@ComponentScan(basePackages={"com.mykala.consumer.api.repository"})
public class AppConfig {

	
	//private CascadingMongoEventListener cascadingMongoEventListener;

	@Bean
	public CascadingMongoEventListener cascadingMongoEventListener() {
		return new CascadingMongoEventListener();
	}

	
	
	
}
