package com.digital.heroisapi;

import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDynamoDBRepositories
public class HeroisapiApplication {

	public static void main(String[] args) {

		SpringApplication.run(HeroisapiApplication.class, args);
		System.out.println("Super poderes com webflux");
	}

}
