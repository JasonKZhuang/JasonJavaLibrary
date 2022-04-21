package com.jasonz.oop.collection.set;

public class StudentForSet {
    String name;
    int age;
    float marks;

    public StudentForSet() {
        super();
    }

    public StudentForSet(String name, int age, float marks) {
        this.name = name;
        this.marks = marks;
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

    public float getMarks() {
        return marks;
    }

    public void setMarks(float marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Student [name=" + name + ", age=" + age + ", marks=" + marks + "]";
    }

}
