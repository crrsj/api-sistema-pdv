package br.com.pdv;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "API - Sistema PDV",
				version = "1.0",
				description = "API para us sistema de PDV.",
				contact = @Contact(name = "Carlos Roberto", email = "crrsj1@gmail.com")
		)
)
public class PdvApplication {

	public static void main(String[] args) {
		SpringApplication.run(PdvApplication.class, args);
	}

}
