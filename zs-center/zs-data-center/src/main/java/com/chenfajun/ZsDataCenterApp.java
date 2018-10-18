package com.chenfajun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ZsDataCenterApp {
	public static void main(String[] args) {
        SpringApplication.run(ZsDataCenterApp.class, args);
    }

}
