package com.jasonz.codility;

import com.jasonz.utilities.GenerateExampleData;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Jason Zhuang
 * @created 2024.03.22 10:40
 * @project JasonJavaLibrary
 * @description: different ways for
 * counting how many distinct numbers in the array
 * <p>
 * experiment result:
 * useHashSet for [100000000] numbers spent [817] milliseconds, get result [100]
 * useStream for [100000000] numbers spent [1012] milliseconds, get result [100]
 * useArraySort for [100000000] numbers spent [2103] milliseconds, get result [100]
 * <p>
 * the winner is using HashSet
 */
public class CountDistinctNumbers {

    private static final int num = 10000 * 10000;

    public static void main(String[] args) {
        CountDistinctNumbers ins = new CountDistinctNumbers();
        int[] arr = GenerateExampleData.generateRandomIntArray(num);

        int count = 0;
        long startTime = 0;
        long endTime = 0;

        // use hash set
        startTime = System.currentTimeMillis();
        count = ins.useHashSet(arr);
        endTime = System.currentTimeMillis();
        System.out.printf("useHashSet for [%d] numbers spent [%d] milliseconds, get result [%d]%n", num, endTime - startTime, count);

        // use java stream
        startTime = System.currentTimeMillis();
        count = ins.useStream(arr);
        endTime = System.currentTimeMillis();
        System.out.printf("useStream for [%d] numbers spent [%d] milliseconds, get result [%d]%n", num, endTime - startTime, count);

        // use array sorting
        startTime = System.currentTimeMillis();
        count = ins.useArraySort(arr);
        endTime = System.currentTimeMillis();
        System.out.printf("useArraySort for [%d] numbers spent [%d] milliseconds, get result [%d]%n", num, endTime - startTime, count);

    }

    private int useHashSet(int[] arr) {
        Set<Integer> result = new HashSet<>();
        for (int e : arr) {
            result.add(e);
        }
        return result.size();
    }

    private int useStream(int[] arr) {
        return Arrays.stream(arr).distinct().toArray().length;
    }

    private int useArraySort(int[] arr) {
        Arrays.sort(arr);
        int count = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) {
                count++;
            }
        }
        return count;
    }


}
