package com.jasonz.dataStructures.arrary;

import com.jasonz.dataStructures.dto.Product;

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
    private int[][] x;

    //声明数组时候不能指定数组长度,以下是错误的
    //private int a[5];

    public static void main(String[] args) {
        ExampleSimpleArray obj = new ExampleSimpleArray();
        obj.exampleArray();
    }

    public static int[] initArray(int count) {
        int[] retArray = new int[count];
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            retArray[i] = random.nextInt(1000);
        }
        return retArray;
    }

    private void exampleArray() {
        //创建数组对象
        //数组声明
        int[] scores = new int[100];
        scores[0] = 100;

        //数组长度用变量表示
        int size = 100;
        int[] scores2 = new int[size];

        //数组对象引用, they point to the same array address
        scores2 = scores;

        System.out.println("scores[0]=" + scores[0]);
        System.out.println("scores2[0]=" + scores2[0]);
        // change the value of one array, the other array's value also changed,
        // because they point to the same memory address
        scores2[0] = 200;
        System.out.println("scores[0]=" + scores[0]);
        System.out.println("scores2[0]=" + scores2[0]);
        System.out.println("scores2.equals(scores) is " + scores2.equals(scores));

        //数组初始化
        int[] scores3 = new int[]{1, 2, 3, 4, 5};
        for (int k : scores3) {
            System.out.println(k);
        }

        //多维数组
        String[][] rooms = new String[3][];//三层楼,每层楼有不同的房间数
        //initial the first dimension
        rooms[0] = new String[5];
        rooms[1] = new String[4];
        rooms[2] = new String[3];

        //initial the second dimension
        rooms[0][0] = "Tom";
        rooms[0][4] = "Jemmy";
        rooms[1][0] = "Karen Marsh";
        rooms[1][3] = "Dim work";
        rooms[2][0] = "Chris";
        rooms[2][2] = "Linda";

        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[i].length; j++) {
                System.out.println("rooms[" + i + "][" + j + "] is " + rooms[i][j]);
            }
        }
    }

    private void usingArraysMethods() {
        int[] myArray = initArray(100);

        // sorting an integer array
        Arrays.sort(myArray);

        // sorting parts of an integer array
        Arrays.sort(myArray, 5, 10);

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
        Product[] products = ExampleObjectArray.initProductsArray(100);
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

