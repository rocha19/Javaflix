package com.learn.javaflix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.learn.javaflix.libs.SqLite;

@SpringBootApplication
public class JavaflixApplication {
	public static void main(String[] args) {
		SqLite sqLite = new SqLite();
		sqLite.handle();
		SpringApplication.run(JavaflixApplication.class, args);
	}
}
