package com.jasonz;

import com.jasonz.java8Features.streamAPI.PersonObject;
import com.jasonz.oop.inheritance.base.override.Test;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        Person p = new Person();
        p.setId(99);
        System.out.println(p.getId());

        testMethod(p);
        System.out.println(p.getId());

        String name = "";
        changeToHomer(name);
        System.out.println(name);

        StringBuilder name2 = new StringBuilder("Homer ");
        addSureName(name2);
        System.out.println(name2);

    }

    public static void testMethod(Person p){
        p = new Person();
        p.setId(100);
    }

    static void changeToHomer(String name) {
        name = "Homer";
    }

    static void addSureName(StringBuilder name) {
        name.append("Simpson");
    }

}
