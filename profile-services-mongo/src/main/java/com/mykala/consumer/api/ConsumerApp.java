package com.mykala.consumer.api;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackages={"com.mykala.consumer.api.repository"})
@SpringBootApplication
public class ConsumerApp {

	public static void main( String[] args )
    {
		System.out.println(new Date());
    	SpringApplication.run(ConsumerApp.class, args);
    }
	
	
}
