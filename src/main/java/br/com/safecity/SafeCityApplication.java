package br.com.safecity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import br.com.safecity.config.AppProperties;

@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)
public class SafeCityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SafeCityApplication.class, args);
	}

}
