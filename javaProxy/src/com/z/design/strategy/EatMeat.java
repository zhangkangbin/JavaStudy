package com.z.design.strategy;

/**
 * User: zhangkb
 * Date: 2019/4/24 0024
 * Time: 上午 9:51
 */
public class EatMeat implements Eat {
    @Override
    public void eatSomething() {

        switch (action) {
            case "beef":
                System.out.println("I usually eat beef");
                break;
            case "chicken":
                System.out.println("I usually eat chicken");
                break;
            default:
                System.out.println("I usually eat meat");
                break;
        }


    }

    private String action;

    /**
     * set action
     * @param action
     */
    @Override
    public void setAction(String action) {
        this.action = action;
    }

    @Override
    public int getType() {
        return 2;
    }
}
