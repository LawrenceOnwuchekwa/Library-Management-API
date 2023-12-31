package com.libraryweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@SpringBootApplication
public class LibraryWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryWebApplication.class, args);
	}

}
