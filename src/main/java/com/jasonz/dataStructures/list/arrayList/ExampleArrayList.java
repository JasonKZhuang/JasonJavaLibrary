package com.jasonz.dataStructures.list.arrayList;

import com.jasonz.dataStructures.list.SortingType;
import com.jasonz.dataStructures.list.Student;

import java.util.*;
import java.util.stream.Collectors;

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

        //remove duplicates from arraylist only for String
        List<String> strList = new ArrayList<>();
        strList.add("Ryan");
        strList.add("Marc");
        strList.add("Jason");
        strList.add("Peter");
        strList.add("Peter");
        List<String> newStrList = instance.removeDuplicatesForString(strList);
        System.out.println(newStrList);

        // Using Iterator method remove duplicates from arraylist for Student object
        // in which override equal() method
        List<Student> newStudents1 = instance.removeDuplicates(myStudentList);
        instance.printStudentList(newStudents1);

        // Using LinkedHashSet method remove duplicates from arraylist for Student object
        List<Student> newStudents2 = instance.removeDuplicatesWithSet(myStudentList);
        instance.printStudentList(newStudents2);

        // Using Stream distinct() method remove duplicates from arraylist for Student object
        List<Student> newStudents3 = instance.removeDuplicatesWithStream(myStudentList);
        instance.printStudentList(newStudents3);


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
        student = new Student("Peter", 25, 55.5f);
        argStudent.add(student);
    }

    public void printStudentList(List<Student> argStudents) {
        for (Student student : argStudents) {
            System.out.println(student.toString());
        }
        System.out.println();
    }

    public List<String> removeDuplicatesForString(List<String> argList) {
        List<String> retList = new ArrayList<>();
        for (String s : argList) {
            if (!retList.contains(s)){
                retList.add(s);
            }
        }
        return retList;
    }

    public List<Student> removeDuplicates(List<Student> students) {
        List<Student> retList = new ArrayList<>();
        for (Student s : students) {
            if (!retList.contains(s)){
                retList.add(s);
            }
        }
        return retList;
    }

    public List<Student> removeDuplicatesWithSet(List<Student> students) {
        List<Student> retList = new ArrayList<>();

        // Create a new LinkedHashSet
        Set<Student> set = new LinkedHashSet<>();

        // Add the elements to set
        set.addAll(students);

        // Clear the list
        // students.clear();

        // add the elements of set
        // with no duplicates to the list
        retList.addAll(set);

        // return the list
        return retList;
    }

    public List<Student> removeDuplicatesWithStream(List<Student> students) {
        // Construct a new list from the set constucted from elements
        // of the original list
        List<Student> retList = students.stream()
                .distinct()
                .collect(Collectors.toList());

        // return the list
        return retList;
    }




}
