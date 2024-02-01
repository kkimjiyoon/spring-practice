package com.nhnacademy.edu.springframework.service;


import com.nhnacademy.edu.springframework.sender.MessageSender;
import org.springframework.stereotype.Component;

@Component
public class MessageSendService {
    private final MessageSender messageSender; // 의존성 주입 필요

    public MessageSendService(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    public void doSendMessage() {
        messageSender.sendMessage();
    }
}
