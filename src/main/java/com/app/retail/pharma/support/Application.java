package com.app.retail.pharma.support;

import java.util.stream.Stream;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.app.retail.pharma.support.entities.Recommendation;
import com.app.retail.pharma.support.repositories.RecommendationRepo;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner init(RecommendationRepo recommendationRepo) {
        return args -> {
            Stream.of("John", "Julie", "Jennifer", "Helen", "Rachel").forEach(name -> {
            	Recommendation recommendation = new Recommendation(name, name.toLowerCase() + "@domain.com");
            	recommendationRepo.save(recommendation);
            });
            recommendationRepo.findAll().forEach(System.out::println);
        };
    }
}