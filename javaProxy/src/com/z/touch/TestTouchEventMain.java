package com.z.touch;

public class TestTouchEventMain {

    public static void main(String[] args) {

        ViewGroup viewGroup=new ViewGroup("1-0");

        ViewGroup viewGroup11=new ViewGroup("1-1");



        viewGroup.addView(viewGroup11);
        viewGroup.addView(new View("1-2"));


        viewGroup11.addView(new ViewGroup("2-1"));

        viewGroup.dispatchTouchEvent(new MotionEvent());

    }
}
