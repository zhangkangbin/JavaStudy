package com.z.handler;

public class Handler {

    private Looper looper;

    private Handler handler;
    public Handler() {

        looper=Looper.getLooper();
    }

    public void sendMessage(int what, String msg) {

        looper.sendMessage(what,msg,this);
    }
    public void handleMessage(Message message) {

    }
}
