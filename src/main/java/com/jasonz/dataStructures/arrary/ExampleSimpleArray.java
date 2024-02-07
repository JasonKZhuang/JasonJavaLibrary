package com.jasonz.dataStructures.arrary;

import com.jasonz.dto.Product;
import com.jasonz.dto.ProductManager;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

/**
 * @creator Jason Zhuang
 * @create-time 2013-7-17
 * copywrite kkcms.com
 */
public class ExampleSimpleArray {
    private String[] names;

    private String[] names2;

    //二维数组声明
    private int[][] arr2D;

    //声明数组时候不能指定数组长度,以下是错误的
    //private int a[5];

    public static int[] initArray(int count) {
        int[] retArray = new int[count];
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            retArray[i] = random.nextInt(1000);
        }
        return retArray;
    }

    public static void printArray(int[] argArray) {
        for (int i = 0; i < argArray.length; i++) {
            if (i != 0 && i % 10 == 0) {
                System.out.println();
            }
            System.out.printf("%10d | ", argArray[i]);
        }
        System.out.println();
    }

    private void usingArraysMethods() {

        int[] myArray = initArray(100);

        /**
         * The array must be sorted (as by the sort(int[]) method) prior to making this call.
         * If it is not sorted, the results are undefined.
         * If the array contains multiple elements with the specified value, there is no guarantee which one will be found.
         */
        int i = Arrays.binarySearch(myArray, 10);

        // copy sub array to a new array
        int[] subCopyArray = Arrays.copyOfRange(myArray, 1, 10);

        // change array to stream, and operating in the flow of stream, return a new array
        int[] newStreamArray = Arrays.stream(myArray).map((e)-> {
          return e+1;
        } ).toArray();

        // The sorting algorithm is a Dual-Pivot Quicksort by Vladimir Yaroslavskiy, Jon Bentley and Josh Bloch.
        // This algorithm offers O(n log(n)) performance on all data sets, and is typically faster than traditional (one-pivot) Quicksort implementations.
        Arrays.parallelSort(myArray);

        // initialize a string list by using arrays.asList()
        List<String> myStringList = Arrays.asList("anyString1", "anyString2", "anyString3", "anyStringN");


        // sorting objects array
        Product[] products = ProductManager.initProductsArray(100);
        Arrays.sort(products, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return Integer.compare(o1.getId(), o2.getId());
            }
        });

        // sorting parts of objects array
        Arrays.sort(products, 5, 10, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return Integer.compare(o1.getId(), o2.getId());
            }
        });
    }
}

