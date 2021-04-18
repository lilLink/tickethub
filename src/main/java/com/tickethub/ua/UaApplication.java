package com.tickethub.ua;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
@EntityScan(basePackages = {"com.tickethub.ua"})
public class UaApplication {

	public static void main(String[] args) {
		SpringApplication.run(UaApplication.class, args);
	}

}
