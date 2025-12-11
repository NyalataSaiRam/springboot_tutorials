package com.example.SpringDataJpaDemo;

import com.example.SpringDataJpaDemo.repositories.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class SpringDataJpaDemoApplication implements CommandLineRunner {

    private AuthorRepository authorRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaDemoApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {

    }
}
