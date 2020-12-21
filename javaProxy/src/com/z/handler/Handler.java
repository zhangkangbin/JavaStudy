package com.z.handler;

public class Handler {

    private Looper looper;
    public MessageQueue  queue;
    public Callback  callback;

    public Handler() {
       this(null,Looper.getLooper());
    }
    public Handler(Callback callback,Looper looper) {

        this.callback=callback;
        this.looper=looper;
        this.queue=looper.queue;
    }

    public void sendMessage(int what, String msg) {

        queue.enqueueMessage(new Message(what, msg, this));
    }

    public void handleMessage(Message message) {

    }
    public interface Callback {

        boolean handleMessage(Message msg);
    }
}
