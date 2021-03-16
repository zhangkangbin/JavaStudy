package com.z.touch;

import com.z.touch.core.MotionEvent;
import com.z.touch.core.ViewGroup;

public class InterceptViewGroup extends ViewGroup {
    public InterceptViewGroup(String s) {
        super(s);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        System.out.println(tag+"：--------InterceptViewGroup------------ ");
        return true;
    }
}
