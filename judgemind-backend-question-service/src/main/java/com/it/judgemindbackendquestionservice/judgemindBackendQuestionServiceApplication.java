package com.it.judgemindbackendquestionservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.it.judgemindbackendquestionservice.mapper")
@EnableScheduling
@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true)
@ComponentScan("com.it")
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"com.it.judgemindbackendserviceclient.service"})
public class judgemindBackendQuestionServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(judgemindBackendQuestionServiceApplication.class, args);
    }

}
