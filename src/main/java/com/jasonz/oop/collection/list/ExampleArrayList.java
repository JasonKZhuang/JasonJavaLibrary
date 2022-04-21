package com.jasonz.oop.collection.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author : Jason Zhuang
 * @date : 21/4/2022
 * @description :
 * @Reference: https://techvidvan.com/tutorials/java-array-vs-arraylist/
 * <p>
 * Arrays in Java are static in nature,
 * i.e we can not change their length.
 * The length of the array is fixed.
 * Once we declare the length at the time of array creation, we can not change its size again.
 * On the other hand, ArrayList in Java is dynamic in nature, therefore we also sometimes call it a re-sizeable array or dynamic array. ArrayList can automatically grow in their size if we add more limits beyond its defined capacity, therefore it is dynamic in nature.
 * Since ArrayList internally works based on the array, you may think that performance of both of them would be the same.
 * Basically, it can be considered true but the performance of ArrayList may be slower as compared to Arrays because it has some extra functionality other than Arrays. The performance of ArrayList affects mainly in terms of CPU time and memory usage.
 * Any resize() operation on ArrayList may degrade the performance of ArrayList since it involves the creation of a new array and then copying the content from the old array to the new array. This operation, therefore, slows down the performance of ArrayList.
 */
public class ExampleArrayList {
    public static void main(String[] args) {
        ExampleArrayList instance = new ExampleArrayList();
        List myStudentList = new ArrayList<>();
        instance.initStudentList(myStudentList);
        instance.printStudentList(myStudentList);
        //sorting by age ASC
        Collections.sort(myStudentList, new ComparatorByAge(SortingType.ASC));
        instance.printStudentList(myStudentList);
        //sorting by age DESC
        Collections.sort(myStudentList, new ComparatorByAge(SortingType.DESC));
        instance.printStudentList(myStudentList);
    }

    public void initStudentList(List argStudent) {
        Student student;
        student = new Student("Marc", 50, 95.5f);
        argStudent.add(student);
        student = new Student("Jason", 40, 85.5f);
        argStudent.add(student);
        student = new Student("Ryan", 60, 75.5f);
        argStudent.add(student);
        student = new Student("Peter", 25, 55.5f);
        argStudent.add(student);
    }

    public void printStudentList(List<Student> argStudents) {
        for (Student student : argStudents) {
            System.out.println(student.toString());
        }
        System.out.println();
    }

}
