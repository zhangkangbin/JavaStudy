package com.z.design.template;

/**
 * User: zhangkb
 * Date: 2019/5/16 0016
 * Time: 下午 5:52
 */
public abstract class Game {
    abstract void initialize();
    abstract void startPlay();
    abstract void endPlay();

    //模板
    public final void play(){

        //初始化游戏
        initialize();

        //开始游戏
        startPlay();

        //结束游戏
        endPlay();
    }
}