package com.z.design.proxy;

public class MyCall implements IUser{
    @Override
    public void findGirl() {

    }

    @Override
    public My findBoy() {
        return new My();
    }
}
