package com.nhnacademy.edu.springframework.config;

import com.nhn.dooray.client.DoorayHookSender;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = "com.nhnacademy.edu.springframework")
@PropertySource("classpath:sender.properties")
public class MessageSenderConfig {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
    @Bean
    public DoorayHookSender doorayHookSender(RestTemplate restTemplate, @Value("${hookUrl}") String url) {
        return new DoorayHookSender(restTemplate, url);
    }
}
