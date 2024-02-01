package com.nhnacademy.edu.springframework;

import com.nhnacademy.edu.springframework.service.MessageSendService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml")) {
            MessageSendService service = context.getBean("messageSendService", MessageSendService.class);
            service.doSendMessage();
        }
    }
}