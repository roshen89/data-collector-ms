package com.cybercube;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableEurekaClient
public class DataCollectorMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataCollectorMsApplication.class, args);
	}

}
