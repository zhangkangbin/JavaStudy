package com.z.list.link;

public class DataBean {
    public DataBean(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public  String name;
    public String age;

    @Override
    public String toString() {
        return "DataBean{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
