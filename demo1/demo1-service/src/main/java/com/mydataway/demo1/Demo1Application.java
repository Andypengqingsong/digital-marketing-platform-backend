package com.mydataway.demo1;

import com.mydataway.utils.SpringContextHolder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author xuxueli 2018-10-28 00:38:13
 */
@SpringBootApplication
@EnableFeignClients(basePackages = {"com.mydataway.*","com.xxl.*"})
@EnableDiscoveryClient
@ComponentScan(basePackages = {"com.mydataway.utils","com.mydataway.demo1.*"})
//@EnableCircuitBreaker
public class Demo1Application {

	public static void main(String[] args) {
        SpringApplication.run(Demo1Application.class, args);
	}

	@Bean
	public SpringContextHolder springContextHolder() {
		return new SpringContextHolder();
	}

	@Bean
	public ServletWebServerFactory webServerFactory() {
		TomcatServletWebServerFactory fa = new TomcatServletWebServerFactory();
		fa.addConnectorCustomizers(connector -> connector.setProperty("relaxedQueryChars", "[]{}"));
		return fa;
	}

}