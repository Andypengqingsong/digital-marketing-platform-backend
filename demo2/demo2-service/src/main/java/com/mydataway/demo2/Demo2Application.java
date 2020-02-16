package com.mydataway.demo2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author xuxueli 2018-10-28 00:38:13
 */
@SpringBootApplication
@EnableFeignClients(basePackages = "com.mydataway.*")
@ComponentScan(basePackages = "com.mydataway")
@EnableDiscoveryClient
public class Demo2Application {

	public static void main(String[] args) {
        SpringApplication.run(Demo2Application.class, args);
	}

}