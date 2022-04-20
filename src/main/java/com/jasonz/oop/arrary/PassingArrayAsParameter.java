package com.jasonz.oop.arrary;

/**
 * @author : Jason Zhuang
 * @date : 21/4/2022
 * @description :
 */
public class PassingArrayAsParameter {
    public static void main(String[] args) {
        PassingArrayAsParameter practice = new PassingArrayAsParameter();
        //
        int[] myArray = new int[]{2, 3};
        System.out.println("initial array value: ");
        for (int v : myArray) {
            System.out.println(v);
        }
        //
        System.out.println("after change array value: ");
        int[] newArray = practice.changeArray(myArray);
        for (int v : myArray) {
            System.out.println(v);
        }
        for (int v : newArray) {
            System.out.println(v);
        }
        //the conclusion is:
        // passing array as parameter is only passing the reference (memory address)
        // pay attention to ArrayIndexOutOFBoundExceptions
    }

    private int[] changeArray(int[] argArray) {
        int[] newArray = argArray;
        for (int i = 0; i < argArray.length; i++) {
            newArray[i] = argArray[i] * 2;
        }
        return newArray;
    }


}
