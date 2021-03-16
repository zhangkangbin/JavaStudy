package com.z.touch;

public class View implements TouchEvent{
    protected String tag="";
    public View(String tag){
        this.tag=tag;
    }
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        onTouchEvent(ev);
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        System.out.println(tag+"：----------------onTouchEvent: "+tag);
        return false;
    }
}
