package com.jasonz.algorithms.sort;

/**
 * @author : Jason Zhuang
 * @date : 5/6/2022
 * @description :
 */
public class ShellSort {
    public static void main(String[] args) {

    }

    /**
     * 希尔排序
     * @param array
     * @return
     */
    public static int[] ShellSort(int[] array) {
        int len = array.length;
        int temp, gap = len / 2;
        while (gap > 0) {
            for (int i = gap; i < len; i++) {
                temp = array[i];
                int preIndex = i - gap;
                while (preIndex >= 0 && array[preIndex] > temp) {
                    array[preIndex + gap] = array[preIndex];
                    preIndex -= gap;
                }
                array[preIndex + gap] = temp;
            }
            gap /= 2;
        }
        return array;
    }
}
