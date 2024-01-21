package com.jasonz.algorithms.sort;

import com.jasonz.dataStructures.arrary.ExampleSimpleArray;

/**
 * @author Jason Zhuang
 * @created 2024.01.20 18:26
 * @project JasonJavaLibrary
 * @description:
 */
public class SortingMainTest {

    public static void main(String[] args) {
        int[] myArray;

        // ===Bubble Sort============================================================= //
//        myArray = ExampleSimpleArray.initArray(10);
//        System.out.println("=== Before sorting       ===");
//        printArray(myArray);
//        BubbleSort.bubbleSort(myArray);
//        System.out.println("=== After bubble sorting ===");
//        printArray(myArray);

        // ===Optimized Bubble Sort=================================================== //
//        myArray = ExampleSimpleArray.initArray(50);
//        System.out.println("=== Before sorting       ===");
//        printArray(myArray);
//        BubbleSort.bubbleSortOptimized(myArray);
//        System.out.println("=== After optimized bubble sorting ===");
//        printArray(myArray);

        // ===Selection Sort============================================================= //
//        myArray = ExampleSimpleArray.initArray(5);
//        System.out.println("=== Before sorting       ===");
//        printArray(myArray);
//        SelectionSort.selectionSort(myArray);
//        System.out.println("=== After Selection sorting ===");
//        printArray(myArray);

        // ===Selection Sort============================================================= //
        // first, last, middle, random
//        myArray = ExampleSimpleArray.initArray(5);
//        System.out.println("=== Before sorting       ===");
//        printArray(myArray);
//        QuickSort.quickSort(myArray,0, myArray.length - 1, PivotPosition.first.name());
//        System.out.println("=== After Quick sorting ===");
//        printArray(myArray);

//        myArray = ExampleSimpleArray.initArray(5);
//        System.out.println("=== Before sorting       ===");
//        printArray(myArray);
//        QuickSort.quickSort(myArray,0, myArray.length - 1,  PivotPosition.last.name());
//        System.out.println("=== After Quick sorting ===");
//        printArray(myArray);

//        myArray = ExampleSimpleArray.initArray(5);
//        System.out.println("=== Before sorting       ===");
//        printArray(myArray);
//        QuickSort.quickSort(myArray,0, myArray.length - 1,  PivotPosition.random.name());
//        System.out.println("=== After Quick sorting ===");
//        printArray(myArray);

        myArray = ExampleSimpleArray.initArray(5);
        System.out.println("=== Before sorting       ===");
        printArray(myArray);
        QuickSort.quickSort(myArray, 0, myArray.length - 1, PivotPosition.hoare.name());
        System.out.println("=== After Quick sorting ===");
        printArray(myArray);
    }

    private static void printArray(int[] argArray){
        for(int i=0;i<argArray.length;i++){
            if (i!=0 && i%10 ==0){
                System.out.println();
            }
            System.out.printf("%10d | ", argArray[i]);
        }
        System.out.println();
    }
}
