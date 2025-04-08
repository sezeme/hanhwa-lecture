package com.sezeme.secondservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@EnableDiscoveryClient
public class Chap02SecondServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(Chap02SecondServiceApplication.class, args);
    }

}
