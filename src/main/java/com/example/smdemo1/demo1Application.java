package com.example.smdemo1;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class demo1Application {

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(demo1Application.class);
		application.setBannerMode(Banner.Mode.OFF);
		application.run(args);
	}

}

