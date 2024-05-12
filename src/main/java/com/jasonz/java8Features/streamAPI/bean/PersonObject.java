package com.jasonz.java8Features.streamAPI.bean;

import lombok.Data;
import lombok.ToString;

/**
 * @author : Jason Zhuang
 * @date : 8/4/2022
 * @description :
 */
@Data
@ToString
public class PersonObject {
    private String name;
    private Gender gender;
    private String faculty;
    private double mark;
    private int age;
    private boolean isSeniorEngineer = false;

    public PersonObject(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public PersonObject(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
    }

    public PersonObject(String argName, String argFaculty, Double argMark) {
        this.name = argName;
        this.faculty = argFaculty;
        this.mark = argMark;
    }

}
