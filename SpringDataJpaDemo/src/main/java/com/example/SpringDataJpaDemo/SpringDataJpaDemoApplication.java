package com.example.SpringDataJpaDemo;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class SpringDataJpaDemoApplication implements CommandLineRunner {

    private final StudentRepository studentReposiory;

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaDemoApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        studentReposiory.save(
                Student
                .builder().
                firstName("sai")
                .lastName("ram")
                .email("sdf@sdf.com")
                .age(20)
                .build()
        );
    }
}
