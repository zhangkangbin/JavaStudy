package com.z.design.filter;
import java.util.ArrayList;
import java.util.List;

/**
 * Date: 2019/5/14 0013
 * Time: 上午 9:41
 * 过滤器模式
 *过滤器模式（Filter Pattern）或标准模式（Criteria Pattern）是一种设计模式，这种模式允许开发人员使用不同的标准来过滤一组对象，
 * 通过逻辑运算以解耦的方式把它们连接起来。这种类型的设计模式属于结构型模式，它结合多个标准来获得单一标准。
 * @author zhangkb
 */

public class FilterPatternDemo {

    public static void main(String[] args) {

        List<Person> personList = new ArrayList<>();
        personList.add(new Person("1", 18, false));
        personList.add(new Person("2", 17, false));
        personList.add(new Person("3", 30, true));
        personList.add(new Person("4", 26, false));
        personList.add(new Person("5", 43, false));

        IPersonFilter myFilter = new MyFilter();
        printList(myFilter.doFilter(personList));

        System.out.println("==================================================");

        IPersonFilter motherFilter = new MotherFilter();
        printList(motherFilter.doFilter(personList));


        System.out.println("==================================================");

        IPersonFilter fatherFilter = new FatherFilter(motherFilter);
        printList(fatherFilter.doFilter(personList));
    }

    private static void printList(List<Person> list) {


        for (Person person : list) {
            System.out.println(person.toString());
        }


    }
}