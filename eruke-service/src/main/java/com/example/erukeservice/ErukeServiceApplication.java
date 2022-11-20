package com.example.erukeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class ErukeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ErukeServiceApplication.class, args);
	}

}
