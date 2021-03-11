package com.z.touch;

public class TestTouchEventMain {

    public static void main(String[] args) {

        ViewGroup viewGroup=new ViewGroup("1-0");

        ViewGroup viewGroup11=new InterceptViewGroup("1-1");
      //  ViewGroup viewGroup11=new InterceptViewGroup("1-1");
        viewGroup11.addView(new ViewGroup("2-1"));


        viewGroup.addView(viewGroup11);
        viewGroup.addView(new View("1-2"));




        viewGroup.dispatchTouchEvent(new MotionEvent());

    }
}
