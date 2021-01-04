package com.z.handler;

public class Handler {

    private final Looper looper;
    public MessageQueue  queue;
    public Callback  callback;

    public Handler() {
       this(null,Looper.getLooper());
    }
    public Handler(Callback callback,Looper looper) {

        this.callback=callback;
        this.queue=looper.queue;
        this.looper=looper;
    }

    public void sendMessage(int what, String msg) {

        queue.enqueueMessage(new Message(what, msg, this));
    }

    public void handleMessage(Message message) {

        if(callback!=null){
            callback.handleMessage(message);
        }

    }
    public final Looper getLooper() {
        return looper;
    }

    public interface Callback {

        boolean handleMessage(Message msg);
    }
}
