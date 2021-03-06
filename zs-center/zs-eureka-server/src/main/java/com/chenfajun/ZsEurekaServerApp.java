package com.chenfajun;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class ZsEurekaServerApp {

    public static void main(String[] args) {
        new SpringApplicationBuilder(ZsEurekaServerApp.class).web(true).run(args);
    }
}
