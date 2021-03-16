package com.z.touch.core;

public interface TouchEvent {
     boolean dispatchTouchEvent(MotionEvent ev) ;
     boolean onTouchEvent(MotionEvent ev) ;

}
