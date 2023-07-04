package com.example.Demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.example")
@SpringBootApplication
public class OtroApplication {

	public static void main(String[] args) {
		SpringApplication.run(OtroApplication.class, args);
	}

}
