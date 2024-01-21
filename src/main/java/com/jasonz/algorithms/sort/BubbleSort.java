package com.jasonz.algorithms.sort;

/**
 * @author : Jason Zhuang
 * @date : 5/6/2022
 * @description :
 * 最佳情况：T(n) = O(n)   最差情况：T(n) = O(n^2)   平均情况：T(n) = O(n^2)
 */
public class BubbleSort {

    /**
     * 冒泡排序
     */
    public static void bubbleSort(int[] argArray) {
        if (argArray.length == 0)
            return;

        // every round, the maximum value will be placed the right-end
        for (int i = 0; i < argArray.length - 1; i++) {
            for (int j = 0; j < argArray.length - (i + 1); j++) {

                // if current value is greater than next one
                // using a temp variable to swap j and j+1 values
                if (argArray[j] > argArray[j + 1]) {
                    int temp = argArray[j];
                    argArray[j] = argArray[j + 1];
                    argArray[j + 1] = temp;
                }
            }
        }

    }

    /**
     * An optimized version of Bubble Sort
     */
    public static void bubbleSortOptimized(int[] argArray) {
        int i, j, temp, n = argArray.length;
        boolean swapped;

        for (i = 0; i < n - 1; i++) {
            swapped = false;
            for (j = 0; j < n - (i + 1); j++) {
                if (argArray[j] > argArray[j + 1]) {

                    // Swap argArray[j] and argArray[j+1]
                    temp = argArray[j];
                    argArray[j] = argArray[j + 1];
                    argArray[j + 1] = temp;
                    swapped = true;
                }
            }

            // If no two elements were swapped by inner loop, then break
            if (!swapped)
                break;
        }
    }
}
