package com.jasonz.java8Features.streamAPI;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * @author : Jason Zhuang
 * @date : 8/4/2022
 * @description :
 */
@Data
@AllArgsConstructor
@ToString
public class PersonObject {
    private String name;
    private int age;
    private boolean isSeniorEngineer = false;

    public PersonObject(String name, int age) {
        this.name = name;
        this.age = age;
    }

}
