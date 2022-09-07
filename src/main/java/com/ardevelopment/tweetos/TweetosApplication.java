package com.ardevelopment.tweetos;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@SpringBootApplication
@EnableMongoRepositories
public class TweetosApplication {


	public static void main(String[] args) {
		SpringApplication.run(TweetosApplication.class, args);
	}
}
