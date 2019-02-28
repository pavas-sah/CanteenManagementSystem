package com.org.canteen;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.org.canteen.api.common.Gender;
import com.org.canteen.api.model.Customer;
import com.org.canteen.api.repository.CustomerRepository;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
class LoadDatabase {

	@Bean
	CommandLineRunner initDatabase(CustomerRepository repository) {
		return args -> {
			log.info("Preloading " + repository.save(new Customer("Bilbo Baggins", 47, Gender.Male)));
			log.info("Preloading " + repository.save(new Customer("Frodo Baggins", 25, Gender.Male)));
		};
	}
}
