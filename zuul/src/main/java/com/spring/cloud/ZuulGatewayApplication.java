package com.spring.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author ：vivaciousis
 * @date ：Created in 2019/9/11 22:06
 * @description：网关应用程序
 * EnableZuulProxy：标识当前应用为 Zuul Server
 * SpringCloudApplication：用于简化配置的组合注解
 */
@EnableZuulProxy
@SpringCloudApplication
public class ZuulGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZuulGatewayApplication.class,args);
    }

}
