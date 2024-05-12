package com.jasonz.codility;

import java.util.Arrays;

/**
 * @author Jason Zhuang
 * @created 2024.04.26 12:32
 * @project JasonJavaLibrary
 * @description:
 */
public class Lesson6MaxProductOfThree {
    public static void main(String[] args) {
        int[] A = new int[3];
        A[0] = -10;
        A[1] = -2;
        A[2] = -4;

        System.out.println(solution(A));
    }

    private static int solution(int[] arr) {
        // sorting log(n)
        int[] newArray = Arrays.stream(arr).sorted().toArray();
        int len = newArray.length;
        int maxProduct = Integer.MIN_VALUE;
        int[] threeElements = new int[3];
        for (int i = 0; i < 4; i++) {
            if (i == 0) {
                threeElements[0] = len - 1;
                threeElements[1] = len - 2;
                threeElements[2] = len - 3;
            }
            if (i == 1) {
                threeElements[0] = 0;
                threeElements[1] = len - 1;
                threeElements[2] = len - 2;
            }
            if (i == 2) {
                threeElements[0] = 0;
                threeElements[1] = 1;
                threeElements[2] = len - 1;
            }
            if (i == 3) {
                threeElements[0] = 0;
                threeElements[1] = 1;
                threeElements[2] = 2;
            }
            int p = newArray[threeElements[0]] * newArray[threeElements[1]] * newArray[threeElements[2]];
            if (p > maxProduct) {
                maxProduct = p;
            }
        }
        return maxProduct;
    }
}
