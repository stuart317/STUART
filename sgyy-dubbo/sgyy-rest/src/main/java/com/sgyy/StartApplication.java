package com.sgyy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

import java.io.IOException;

@SpringBootApplication   /*(scanBasePackages = "com.sgyy.modules")*/
@ImportResource({"classpath:spring/spring-**.xml"})
public class StartApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(StartApplication.class, args);
	}
}
