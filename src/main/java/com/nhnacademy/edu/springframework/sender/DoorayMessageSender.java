package com.nhnacademy.edu.springframework.sender;

import com.nhn.dooray.client.DoorayHook;
import com.nhn.dooray.client.DoorayHookSender;
import com.nhnacademy.edu.springframework.annotation.ExecutionTime;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DoorayMessageSender implements MessageSender {

    @Value("${hookUrl}")
    private String url;

    @Value("${name}")
    private String name;

    @Value("${comment}")
    private String comment;



    /*@Autowired
    private DoorayHookSender doorayHookSender; (필드주입 방식)*/


    /*private DoorayHookSender doorayHookSender;
    public DoorayMessageSender() {

    }
    @Autowired
    public void setDoorayHookSender(DoorayHookSender doorayHookSender) {
        this.doorayHookSender = doorayHookSender;
    }(setter 주입 방식)*/


    private final DoorayHookSender doorayHookSender;

    public DoorayMessageSender(DoorayHookSender doorayHookSender) {
        this.doorayHookSender = doorayHookSender;
    } // (생성자 주입 방식 Autowired 생략 가능)


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
