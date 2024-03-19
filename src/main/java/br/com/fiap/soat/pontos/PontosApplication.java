package br.com.fiap.soat.pontos;

import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDynamoDBRepositories(basePackages = "br.com.fiap.soat.pontos.dynamodb.repositories")
public class PontosApplication {
	public static void main(String[] args) {
		try {
			SpringApplication.run(PontosApplication.class, args);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}