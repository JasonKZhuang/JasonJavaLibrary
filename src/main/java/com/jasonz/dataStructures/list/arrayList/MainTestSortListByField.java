package com.jasonz.dataStructures.list.arrayList;

import com.jasonz.dto.Student;
import com.jasonz.dto.StudentManager;

import java.util.ArrayList;
import java.util.List;

/**
 * @creator Jason Zhuang
 * @create-time 2021-7-17
 * copywrite zhuangkaizhi.com
 */
public class MainTestSortListByField {

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        StudentManager.initStudentList(students,10);

        System.out.println("** Before sorting **:");
        StudentManager.printStudent(students);

        students.sort(new ComparatorByName());

        System.out.println("** After sorting **");
        StudentManager.printStudent(students);

    }

}
