package com.jasonz.dataStructures.objects;

import com.github.javafaker.Faker;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @author Jason Zhuang
 * @created 2024.01.24 17:52
 * @project JasonJavaLibrary
 * @description:
 */
public class StudentManager {

    public static void initStudentArray(Student[] argStudent, int count) {
        Faker faker = new Faker();
        Random random1 = new Random();
        Random random2 = new Random();
        for (int i = 0; i < count; i++) {
            Student student = new Student(
                    faker.name().firstName() + " " + faker.name().lastName(),
                    random1.nextInt(100),
                    random2.nextFloat() * 100
            );
            argStudent[i] = student;
        }
    }

    public static void initStudentList(List<Student> argStudent, int count) {
        Student[] students = new Student[count];
        initStudentArray(students, count);
        argStudent = Arrays.asList(students);
    }

    public static void printStudent(List<Student> argStudents) {
        for (Student student : argStudents) {
            System.out.println(student.toString());
        }
    }

    public static void printStudent(Student[] argStudents) {
        for (Student student : argStudents) {
            System.out.println(student.toString());
        }
        System.out.println("======================================================================");
    }
}
