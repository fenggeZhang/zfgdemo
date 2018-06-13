package com.zfg.test.entitiy;

/**
 * Created by zfg on 2018/5/30
 */
public class MessageEvent {

    private String message;

    public MessageEvent(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
