package com.example.realtimenotification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class RealtimenotificationApplication {

	public static void main(String[] args) {
		SpringApplication.run(RealtimenotificationApplication.class, args);
	}

}
