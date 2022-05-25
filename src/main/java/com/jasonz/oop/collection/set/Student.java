package com.jasonz.oop.collection.set;

import java.util.Objects;

public class Student {
    String name;
    int age;
    float marks;

    public Student() {
        super();
    }

    public Student(String name, int age, float marks) {
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;

        try {
            Student studentInternal = (Student) obj;
            if (
                    studentInternal.getName().equals(name)
                 && studentInternal.getMarks() == marks
                 && studentInternal.getAge() == age
            ) {
                return true;
            } else {
                return false;
            }

        } catch (Exception exp) {
            exp.printStackTrace();
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.toString());
    }
}
