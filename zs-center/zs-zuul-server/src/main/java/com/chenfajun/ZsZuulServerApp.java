package com.chenfajun;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@EnableEurekaClient
@SpringCloudApplication
public class ZsZuulServerApp {

	public static void main(String[] args) {
		SpringApplication.run(ZsZuulServerApp.class, args);
		// new
		// SpringApplicationBuilder(ZuulServerApplication.class).web(true).run(args);
	}

	/*
	 * @Bean public AccessFilter accessFilter() { return new AccessFilter(); }
	 */

}
