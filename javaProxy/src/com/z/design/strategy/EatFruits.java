package com.z.design.strategy;

/**
 * User: zhangkb
 * Date: 2019/4/24 0024
 * Time: 上午 9:50
 *
 * @author zhangkb
 */
public class EatFruits implements Eat {
    @Override
    public void eatSomething() {

        //业务太复杂时候才需要用到
        switch (action) {
            case "banana":
                System.out.println("I usually eat banana");
                break;
            case "pear":
                System.out.println("I usually eat pear");
                break;
            default:
                System.out.println("I usually eat fruits.....");
                break;
        }


    }

    private String action;

    @Override
    public void setAction(String action) {
        this.action = action;
    }

    @Override
    public int getType() {
        return 1;
    }
}
