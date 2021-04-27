package com.z.thread.simple;

import java.util.Random;

/**
 * 任务类
 */
class Task {
    public String tag;
    public Task(String tag) {
        this.tag = tag;
    }

    public void run(){
        //模拟处理任务
        processTask();

    }

    /**
     * 模拟处理任务
     */
    private void processTask() {

        //随机休眠
        int sleep = new Random().nextInt(10) * 1000;
        System.out.println("模拟处理任务耗时："+sleep);
        try {
            Thread.sleep(sleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}