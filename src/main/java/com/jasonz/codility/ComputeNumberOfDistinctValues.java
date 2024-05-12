package com.jasonz.codility;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Jason Zhuang
 * @created 2024.04.26 12:21
 * @project JasonJavaLibrary
 * @description:
 */
public class ComputeNumberOfDistinctValues {
    public static void main(String[] args) {
        Lesson6Distinct ins = new Lesson6Distinct();
        int[] A = new int[6];
        A[0] = 2;
        A[1] = 1;
        A[2] = 1;
        A[3] = 2;
        A[4] = 3;
        A[5] = 1;
       // System.out.println(ins.solution(A));
    }

    public int solution(int[] A) {
        // Implement your solution here
        Set<Integer> setValues = new HashSet<>();
        for (int v : A) {
            setValues.add(v);
        }
        return setValues.size();
    }
}
