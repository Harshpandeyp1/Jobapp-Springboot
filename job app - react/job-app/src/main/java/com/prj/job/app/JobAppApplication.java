package com.prj.job.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {"com.prj.job.app", "com.telusko.springsecdemo.model"})
public class JobAppApplication {
	public static void main(String[] args) {
		SpringApplication.run(JobAppApplication.class, args);
	}
}
