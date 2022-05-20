package com.exercice.TP5;

import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.function.Supplier;
import java.util.logging.Logger;

@SpringBootApplication
public class Tp5Application {

    public static void main(String[] args) {
        SpringApplication.run(Tp5Application.class, args);
    }

    @Bean
    public CommandLineRunner printStudents() {
        return args -> {
            WebClient webClient = WebClient.create();
            Student student = webClient.get()
                    .uri("http://localhost:8080/student/1")
                    .retrieve()
                    .bodyToMono(Student.class)
                    .block();
        };
    }

}