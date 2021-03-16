package com.z.touch;

import java.util.ArrayList;
import java.util.List;

public class ViewGroup extends View {

    private final List<View> list = new ArrayList<>();

    public ViewGroup(String s) {
        super(s);
    }

    public void addView(View view) {
        list.add(view);
    }

    private int getChildSize() {
        return list.size();
    }

    /**
     * onInterceptTouchEvent 是view没有的！
     *
     * @param ev
     * @return
     */
    boolean onInterceptTouchEvent(MotionEvent ev) {

        System.out.println(tag + "：onInterceptTouchEvent 处理开始");
        return false;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {

        System.out.println(tag + "：dispatchTouchEvent 处理开始");


        final boolean intercepted = onInterceptTouchEvent(ev);

        if (!intercepted) {

            for (View child : list) {
                //  child.dispatchTouchEvent(ev);

                dispatchTransformedTouchEvent(ev, child);
            }

        }

        boolean handled = dispatchTransformedTouchEvent(ev, null);
        //   System.out.println(tag+"：----------------dispatchTouchEvent 处理结束");

        return handled;
    }


    private boolean dispatchTransformedTouchEvent(MotionEvent event, View child) {

        if (child == null) {
            return super.dispatchTouchEvent(event);
        } else {

            return child.dispatchTouchEvent(event);
        }
    }


}
