package com.jasonz.algorithms.search;

import com.jasonz.dataStructures.list.Student;
import com.jasonz.dataStructures.list.arrayList.ExampleArrayList;

import java.util.ArrayList;

/**
 * @author Jason Zhuang
 * @created 2024.01.20 13:16
 * @project JasonJavaLibrary
 * @description: Sentinel linear search is a variation of the standard linear search algorithm used to find a target value in an array or list.
 * The basic idea behind this algorithm is to add a sentinel value at the end of the array which is equal to the target value we are looking for.
 * This helps to avoid checking the array boundary condition during each iteration of the loop, as the sentinel value acts as a stopper for the loop.
 * <p>
 * Although in worst-case time complexity both algorithms are O(n). Only the number of comparisons are less in sentinel linear search than linear search
 */
public class SentinelLinerSearch {

    public static void main(String[] args) {
        SentinelLinerSearch ins = new SentinelLinerSearch();
        ArrayList<Student> students = new ArrayList<>();
        ExampleArrayList.initStudentList(students);
        int targetAge = 25;
        System.out.println("============================");
        System.out.println(ins.search(students, targetAge));
        System.out.println("============================");
    }


    public int search(ArrayList<Student> students, int argAge) {
        int len = students.size();

        // Last element of the array
        Student last = students.get(len - 1);

        // Element to be searched is placed at the last index
        Student sentinelStudent = new Student("SentinelStudent", argAge, 0);
        students.set(len-1, sentinelStudent);

        int i = 0;
        while (students.get(i).getAge() != argAge) {
            i++;
        }

        // Put the last element back
        students.set(len - 1, last);
        if (i < len - 1 || last.getAge() == argAge) {
            return i;
        } else {
            return -1;
        }
    }
}
