package com.jasonz.codility;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Jason Zhuang
 * @created 2024.04.26 12:14
 * @project JasonJavaLibrary
 * @description: Write a function
 * <p>
 * class Solution { public int solution(int[] Lesson6Distinct); }
 * <p>
 * that, given an array Lesson6Distinct consisting of N integers, returns the number of distinct values in array Lesson6Distinct.
 * <p>
 * For example, given array Lesson6Distinct consisting of six elements such that:
 * <p>
 * Lesson6Distinct[0] = 2    Lesson6Distinct[1] = 1    Lesson6Distinct[2] = 1
 * Lesson6Distinct[3] = 2    Lesson6Distinct[4] = 3    Lesson6Distinct[5] = 1
 * the function should return 3, because there are 3 distinct values appearing in array Lesson6Distinct, namely 1, 2 and 3.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [0..100,000];
 * each element of array Lesson6Distinct is an integer within the range [−1,000,000..1,000,000].
 * Copyright 2009–2024 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited.
 */
public class Lesson6Distinct {
    public static void main(String[] args) {
        Lesson6Distinct ins = new Lesson6Distinct();
        int[] A = new int[6];
        A[0] = 2;
        A[1] = 1;
        A[2] = 1;
        A[3] = 2;
        A[4] = 3;
        A[5] = 1;
        System.out.println(ins.solution1(A));
        System.out.println(ins.solution2(A));
    }

    public int solution1(int[] A) {
        if (A == null || A.length == 0){
            return 0;
        }
        // Implement your solution here
        Set<Integer> setValues = new HashSet<>();
        for (int v : A) {
            setValues.add(v);
        }
        return setValues.size();
    }

    public int solution2(int[] A) {
        if (A == null || A.length == 0){
            return 0;
        }
        int[] newArray = Arrays.stream(A).sorted().toArray();
        int count = 1;
        for (int i = 0; i < newArray.length - 1; i++) {
            if (newArray[i + 1] != newArray[i]) {
                count = count + 1;
            }
        }
        return count;
    }
}
