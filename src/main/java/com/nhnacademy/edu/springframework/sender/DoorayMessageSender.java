package com.nhnacademy.edu.springframework.sender;

import com.nhn.dooray.client.DoorayHook;
import com.nhn.dooray.client.DoorayHookSender;
import com.nhnacademy.edu.springframework.annotation.ExecutionTime;
import org.springframework.beans.factory.annotation.Value;
public class DoorayMessageSender implements MessageSender {

    @Value("${hookUrl}")
    private String url;

    @Value("${name}")
    private String name;

    @Value("${comment}")
    private String comment;

    private final DoorayHookSender doorayHookSender;

    public DoorayMessageSender(DoorayHookSender doorayHookSender) {
        this.doorayHookSender = doorayHookSender;
    }
    @Override
    @ExecutionTime
    public boolean sendMessage() {
        doorayHookSender.send(DoorayHook.builder()
                        .botName(name)
                        .text(comment)
                        .build());
        return true;
    }
}
