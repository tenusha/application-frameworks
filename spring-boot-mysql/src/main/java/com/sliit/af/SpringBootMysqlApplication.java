package com.sliit.af;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SpringBootMysqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMysqlApplication.class, args);
	}

}
