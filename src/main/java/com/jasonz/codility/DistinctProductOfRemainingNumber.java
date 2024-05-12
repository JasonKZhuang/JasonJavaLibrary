package com.jasonz.codility;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Jason Zhuang
 * @created 2024.03.24 00:46
 * @project JasonJavaLibrary
 * @description:
 */
public class DistinctProductOfRemainingNumber {

    public static void main(String[] args) {
        int[] v = new int[]{9, 16, 4};
        System.out.println(getDistinctProductOfRemainingNumber(v));

    }

    /**
     * @param A
     * @return
     * Product in math is the result of two or more numbers when multiplied together.
     */
    private static int getDistinctProductOfRemainingNumber(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        Set<Long> set = new HashSet<>();
        long product = 1;
        for (int i = 0; i < A.length; i++) {
            product = product * A[i];
        }
        for (int i = 0; i < A.length; i++) {
            set.add(product / A[i]);
        }
        return set.size();
    }

}
