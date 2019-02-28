package com.org.canteen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication(scanBasePackages = { "com.org.canteen" })
@EnableAsync
public class CanteenApplication {
	
	/*
	 * @Bean public RestTemplate restTemplate() { return new RestTemplate(); }
	 */

	public static void main(String[] args) {
		SpringApplication.run(CanteenApplication.class, args);
	}

}
