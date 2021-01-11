package com.z.handler;

/**
 * 控制消息的发送和消息的回调。
 */
public class Handler {
    private final Looper looper;
    public MessageQueue  queue;
    public Callback  callback;
    public Handler() {
       this(null,Looper.getLooper());
    }
    public Handler(Callback callback) {
        this(callback,Looper.getLooper());
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

    }

    public void dispatchMessage(Message message) {
        if(callback!=null){
            if (callback.handleMessage(message)) {
                return;
            }
        }
        handleMessage(message);
    }
    public final Looper getLooper() {
        return looper;
    }
    public interface Callback {
        boolean handleMessage(Message msg);
    }
}
