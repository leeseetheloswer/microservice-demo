package com.leesee.productclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = {"com.leesee.productclient.controller"})
@EnableEurekaClient
@EnableFeignClients("com.leesee.productclient.client")
public class ProductClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProductClientApplication.class, args);
    }
}

