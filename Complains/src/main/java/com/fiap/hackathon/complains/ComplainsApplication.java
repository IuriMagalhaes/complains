package com.fiap.hackathon.complains;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class ComplainsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ComplainsApplication.class, args);
	}

}
