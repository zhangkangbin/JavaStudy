package com.z.touch.core;

public class View implements TouchEvent{
    protected String tag="";
    public View(String tag){
        this.tag=tag;
    }
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {

        if(ev.isConsume){
            return true;
        }

        return  onTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
     //   System.out.println(tag + "View ：onTouchEvent 处理开始");
       // System.out.println(tag+"：----------------onTouchEvent: "+tag);
        return false;
    }
}
