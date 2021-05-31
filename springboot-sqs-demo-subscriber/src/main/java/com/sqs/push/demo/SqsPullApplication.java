package com.sqs.push.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SqsPullApplication {

	public static void main(String[] args) {
		//putting this sleep here so spring boot starts only after local stack has spun up completely.
//		try {
//			Thread.sleep(30000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		SpringApplication.run(SqsPullApplication.class, args);
	}

}
