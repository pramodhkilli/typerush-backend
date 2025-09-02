package com.pramodhkilli.typerush;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@SpringBootApplication
public class TyperushApplication {

	public static void main(String[] args) {
		SpringApplication.run(TyperushApplication.class, args);
	}

}
