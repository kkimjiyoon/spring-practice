package com.nhnacademy.edu.springframework.main;

import com.nhnacademy.edu.springframework.config.MessageSenderConfig;
import com.nhnacademy.edu.springframework.service.MessageSendService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class StereoTypeAnnotationMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MessageSenderConfig.class);
        MessageSendService service = context.getBean("messageSendService", MessageSendService.class);

        service.doSendMessage();
    }
}
