package com.sugodoc.sugodoc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = {
	org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class
})

public class SugodocApplication {

	public static void main(String[] args) {
		SpringApplication.run(SugodocApplication.class, args);
	}

}
