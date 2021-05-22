package br.com.safecity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "br.com.safecity.*")
public class SafeCityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SafeCityApplication.class, args);
	}

}
