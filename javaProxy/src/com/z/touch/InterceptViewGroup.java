package com.z.touch;

public class InterceptViewGroup extends ViewGroup{
    public InterceptViewGroup(String s) {
        super(s);
    }

    @Override
    boolean onInterceptTouchEvent(MotionEvent ev) {
        System.out.println(tag+"：--------InterceptViewGroup------------ ");
        return true;
    }
}
