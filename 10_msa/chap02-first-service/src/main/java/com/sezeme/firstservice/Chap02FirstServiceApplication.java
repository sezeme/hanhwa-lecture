package com.sezeme.firstservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
/* 해당 어플리케이션을 서비스 발견 클라이언트로 설정하는 어노테이션 */
@EnableDiscoveryClient
public class Chap02FirstServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(Chap02FirstServiceApplication.class, args);
    }

}
