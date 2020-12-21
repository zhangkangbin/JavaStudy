package com.z.handler;

public class Message {

    public  Handler target;
    public int what;
    public String massage;

    public Message(int what, String massage,Handler target) {
        this.what = what;
        this.massage = massage;
        this.target=target;
    }

}
