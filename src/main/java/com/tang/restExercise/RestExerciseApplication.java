package com.tang.restExercise;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@SpringBootApplication
public class RestExerciseApplication {

//	public static void main(String[] args) {
//		SpringApplication.run(RestExerciseApplication.class, args);
//	}

//	@Bean
//	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
//		return args -> {
//			System.out.println("Let's inspect the beans provided by Spring Boot:");
//
//			String[] beanNames = ctx.getBeanDefinitionNames();
//			Arrays.sort(beanNames);
//			for(String beanName: beanNames) {
//				System.out.println(beanName);
//			}
//		};
//	}

	private static final Logger log = LoggerFactory.getLogger(RestExerciseApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(RestExerciseApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) {
		return args -> {
			ResponseEntity<Quote[]> response = restTemplate.getForEntity("https://gturnquist-quoters.cfapps.io/api", Quote[].class);
			List<Quote> quotes = Arrays.asList(response.getBody());
//			Collections.sort(quotes, new QuoteIdSortor());
//			quotes.forEach(System.out::println);
		};
	}

}
