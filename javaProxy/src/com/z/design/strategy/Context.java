package com.z.design.strategy;

/**
 * User: zhangkb
 * Date: 2019/4/24 0024
 * Time: 上午 9:53
 */
public class Context {

    private Eat eat;

    public Context(Eat eat) {
        this.eat = eat;
    }

    public void doSomething(){

        if(eat==null){
            System.out.println("I can't find what you like.");
            return;
        }

        eat.eatSomething();
    }
}
