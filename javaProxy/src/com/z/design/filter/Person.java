package com.z.design.filter;

/**
 * User: zhangkb
 * Date: 2019/5/14 0014
 * Time: 上午 10:52
 */
public class Person {
    public Person(String name, int age, boolean isMarital) {
        this.name = name;
        this.age = age;
        this.isMarital = isMarital;
    }

    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isMarital() {
        return isMarital;
    }

    public void setMarital(boolean marital) {
        isMarital = marital;
    }

    private boolean isMarital;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", isMarital=" + isMarital +
                '}';
    }
}
