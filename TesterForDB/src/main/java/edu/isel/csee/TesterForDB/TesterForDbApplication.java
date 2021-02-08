package edu.isel.csee.TesterForDB;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class TesterForDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(TesterForDbApplication.class, args);
	}

}
