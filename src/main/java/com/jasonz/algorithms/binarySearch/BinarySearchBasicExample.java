package com.jasonz.algorithms.binarySearch;

import java.util.Arrays;

/**
 * @author Jason Zhuang
 * @created 2024.05.30 18:34
 * @project JasonJavaLibrary
 * @description:
 */
public class BinarySearchBasicExample {
    public static void main(String[] args) {
        goBinarySearchBasicExample();
    }

    public static void goBinarySearchBasicExample() {
        String[] array1 = {"apple", "banana", "cherry"};

        // descending order
        Arrays.sort(array1, (a, b) -> b.compareTo(a));
        for (String s : array1) {
            System.out.println(s);
        }

        String target = "cherry";
        int left = 0;
        int right = array1.length - 1;

        while (true) {
            int middle = (left + right) / 2;
            if (target.equals(array1[middle])) {
                System.out.println("Found the target: " + target + " at index " + middle);
                break;
            }

            // since descending order, the target is less than the middle, then it should be on the right side
            if (target.compareTo(array1[middle]) < 0) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }

            // beyond the boundary
            if (left > right) {
                System.out.println("Not found the target: " + target);
                break;
            }
        }
    }
}
