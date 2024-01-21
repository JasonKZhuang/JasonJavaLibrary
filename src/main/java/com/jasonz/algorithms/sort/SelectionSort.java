package com.jasonz.algorithms.sort;

/**
 * @author : Jason Zhuang
 * @date : 5/6/2022
 * @description :
 * 最佳情况：T(n) = O(n2)  最差情况：T(n) = O(n2)  平均情况：T(n) = O(n2)
 */
public class SelectionSort {

    /**
     * 选择排序
     */
    public static void selectionSort(int[] argArr) {
        if (argArr.length == 0)
            return;

        // loop through all numbers
        for (int i = 0; i < argArr.length; i++) {
            // set current element as minimum
            int minIndex = i;
            // check all rest right element to be minimum
            for (int j = i+1; j < argArr.length; j++) {
                // found min value
                if (argArr[j] < argArr[minIndex]) {
                    // store the index of min value
                    minIndex = j;
                }
            }

            // swap min value and starting value
            if (minIndex != i) {
                int temp = argArr[minIndex];
                argArr[minIndex] = argArr[i];
                argArr[i] = temp;
            }

        }
    }




}
