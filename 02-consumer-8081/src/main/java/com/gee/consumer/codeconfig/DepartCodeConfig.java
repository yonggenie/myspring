package com.gee.consumer.codeconfig;


import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


/**
 * Feign 项目是一种伪装，最终还是使用的RestTemplate
 */
@Configuration
public class DepartCodeConfig {


    @LoadBalanced
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }



}
