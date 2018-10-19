package com.chenfajun;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ZsWebApp {
	public static void main(String[] args) {
		new SpringApplicationBuilder(ZsWebApp.class).web(true).run(args);
    }

}
