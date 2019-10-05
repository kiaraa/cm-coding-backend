package com.cmcoding;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.cmcoding")
public class CmCodingBackendApplication {


	public static void main(String[] args) {
		for(String arg:args) {
			System.out.println(arg);
		}

		SpringApplication.run(CmCodingBackendApplication.class, args);
	}
}
