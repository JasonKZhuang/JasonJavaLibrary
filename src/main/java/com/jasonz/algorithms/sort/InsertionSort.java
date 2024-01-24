package com.jasonz.algorithms.sort;

/**
 * @author : Jason Zhuang
 * @date : 24/1/2024
 * @description :
 * 最佳情况：T(n) = O(n)   最坏情况：T(n) = O(n^2)   平均情况：T(n) = O(n^2)
 */
public class InsertionSort {

    /**
     * 插入排序
     *
     * @param array
     * @return
     * 1
     */
    public static void sort(int[] array) {
        // if there is only one element
        if (array.length < 2)
            return;
        // walking the array
        for (int i = 1; i < array.length; i++) {

            // get the current element to a variable to be used later comparison
            int currentValue = array[i];
            // index for Next-Left to the current
            int j = i - 1;
            // waling back from j to 0
            // while the previous is greater than current value, then move pre to right one step
            while (j >= 0 && array[j] > currentValue){
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = currentValue;
        }

    }
}
