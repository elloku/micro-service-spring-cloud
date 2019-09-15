package com.spring.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author ：vivaciousis
 * @date ：Created in 2019/9/11 22:01
 * @description：  1. 只需要加上 @EnableEurekaServer 注解就可以让应用变成Eureka Server
 *                 2. pom文件种对应到 spring-cloud-starter-netflix-eureka-server
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaApplication {
    public static void main(String[] args){
        SpringApplication.run(EurekaApplication.class,args);
    }

}
