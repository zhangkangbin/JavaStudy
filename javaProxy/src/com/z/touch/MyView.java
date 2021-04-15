package com.z.touch;

import com.z.touch.core.MotionEvent;
import com.z.touch.core.View;

public class MyView  extends View {
    public MyView(String tag) {
        super(tag);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        System.out.println(tag + "MyView ：dispatchTouchEvent 处理开始");
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        System.out.println(tag + "MyView ：onTouchEvent 处理开始");
       // return super.onTouchEvent(ev);
        return true;
    }
}
