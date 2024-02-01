package com.nhnacademy.edu.springframework.service;


import com.nhnacademy.edu.springframework.sender.MessageSender;

public class MessageSendService {
    private final MessageSender messageSender;

    public MessageSendService(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    public void doSendMessage() {
        messageSender.sendMessage();
    }
}
