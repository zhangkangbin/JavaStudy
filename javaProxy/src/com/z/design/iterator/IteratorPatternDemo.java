package com.z.design.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * 迭代器模式（Iterator Pattern）是 Java 和 .Net 编程环境中非常常用的设计模式。
 * 这种模式用于顺序访问集合对象的元素，不需要知道集合对象的底层表示。
 * 迭代器模式属于行为型模式
 *
 * 比如 {@link java.util.List}
 * User: zhangkb
 * Date: 2019/5/14 0014
 * Time: 下午 4:51
 * @author zhangkb
 */
public class IteratorPatternDemo {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");

        //模仿list迭代
        MyList<String> myList = new MyList<>(list);
        Iterator<String> iterator = myList.getIterator();

        while (iterator.hasNext()){
            String next = iterator.next();
            System.out.println(next);
    }


    }
}
