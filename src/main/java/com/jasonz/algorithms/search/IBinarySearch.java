package com.jasonz.algorithms.search;

import com.jasonz.dataStructures.objects.Student;

import java.util.ArrayList;

/**
 * @author : Jason Zhuang
 * @date : 21/4/2022
 * @description :
 */
public interface IBinarySearch {
    int search(int[] argArray, int targetValue);
    int search(ArrayList<Student> argList, int argValue);

}
