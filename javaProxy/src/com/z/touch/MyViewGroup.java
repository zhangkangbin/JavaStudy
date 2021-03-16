package com.z.touch;

import com.z.touch.core.MotionEvent;
import com.z.touch.core.ViewGroup;

public class MyViewGroup  extends ViewGroup {
    public MyViewGroup(String s) {
        super(s);
    }


    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        System.out.println(tag + "：onInterceptTouchEvent 处理开始");
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        System.out.println(tag + "：dispatchTouchEvent 处理开始");
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        System.out.println(tag + "：onTouchEvent 处理开始");
        return super.onTouchEvent(ev);
    }
}
