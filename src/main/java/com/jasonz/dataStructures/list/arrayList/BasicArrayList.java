package com.jasonz.dataStructures.list.arrayList;

import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;

/**
 * @author Jason Zhuang
 * @created 2023.11.25 19:48
 * @project JasonJavaLibrary
 * @description:
 */
public class BasicArrayList {
    public static void main(String[] args) {
        // Create an ArrayList of Student objects
        ArrayList<Student> students = new ArrayList<>();

        // Add Student objects
        students.add(new Student(1, "John", 20));
        students.add(new Student(2, "Alice", 18));
        students.add(new Student(3, "Bob", 19));

        // Iterate and print the names of students
        for (Student student : students) {
            System.out.println(student.toString());
        }

        // Check if the ArrayList contains a specific student
        Student searchStudent = new Student(2,"Alice", 18);

        if (students.contains(searchStudent)) {
            System.out.println("Student found in the list.");
        } else {
            System.out.println("Student not found in the list.");
        }


    }
}

@Data
@ToString
class Student {
    private final int id;
    private final String name;
    private final int age;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Student student = (Student) obj;

        return id == student.id
                && name.equals(student.name)
                && age == student.age;
    }

    @Override
    public int hashCode() {
        // Ensure that if two objects are equal, they have the same hash code
        return java.util.Objects.hash(id,name,age);
    }
}