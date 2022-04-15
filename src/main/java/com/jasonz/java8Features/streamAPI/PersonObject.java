package com.jasonz.java8Features.streamAPI;

/**
 * @author : Jason Zhuang
 * @date : 8/4/2022
 * @description :
 */
public class PersonObject {
    private String name;
    private int age;

    public PersonObject(String name, int age) {
        this.name = name;
        this.age = age;
    }

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
}
