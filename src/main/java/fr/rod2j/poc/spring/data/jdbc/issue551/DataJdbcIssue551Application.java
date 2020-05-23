package fr.rod2j.poc.spring.data.jdbc.issue551;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;

@SpringBootApplication
@EnableJdbcRepositories
public class DataJdbcIssue551Application {

	public static void main(String[] args) {
		SpringApplication.run(DataJdbcIssue551Application.class, args);
	}

}
