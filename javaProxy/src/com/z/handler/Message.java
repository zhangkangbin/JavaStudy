package com.z.handler;

/**
 * 消息类型定义
 */
public class Message {
    public Handler target;
    public int what;
    public String message;

    public Message(int what, String massage,Handler target) {
        this.what = what;
        this.message = massage;
        this.target=target;
    }

}
