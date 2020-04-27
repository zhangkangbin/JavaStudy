package com.z.handler;

public class Message {

    public int getWhat() {
        return what;
    }

    public void setWhat(int what) {
        this.what = what;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }

    public Message(int what, String massage,Handler handler) {
        this.what = what;
        this.massage = massage;
        this.handler=handler;
    }

    public  Handler handler;
    public int what;
    public String massage;

}
