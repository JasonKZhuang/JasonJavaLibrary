package com.jasonz.dataStructures.set;

import lombok.Getter;

import java.util.Objects;

@Getter
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

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
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
            return studentInternal.getName().equals(name)
                    && studentInternal.getMarks() == marks
                    && studentInternal.getAge() == age;

        } catch (Exception exp) {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.toString());
    }
}
