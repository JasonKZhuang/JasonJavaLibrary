package com.jasonz.oop.collection.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @creator Jason Zhuang
 * @create-time 2021-7-17
 * copywrite zhuangkaizhi.com
 */
public class MainTestSortListByField {

    public static void main(String[] args) {
        List<Student> studentlst = new ArrayList<Student>();

        studentlst.add(new Student("Jason", 1, 80));
        studentlst.add(new Student("Bob", 2, 100));
        studentlst.add(new Student("Anny", 3, 95));

        System.out.println("** Before sorting **:");
        for (Student student : studentlst) {
            System.out.println(student);
        }
        Collections.sort(studentlst, new ComparatorByName());

        System.out.println("** After sorting **");
        for (Student student : studentlst) {
            System.out.println(student);
        }

    }

}
