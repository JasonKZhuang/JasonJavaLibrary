package com.jasonz.oop.arrary;

/**
 * @author : Jason Zhuang
 * @date : 21/4/2022
 * @description :
 */
public class ExampleObjectArray {
    public static void main(String[] args) {
        ExampleObjectArray practice = new ExampleObjectArray();
        //
        Product[] products = practice.testObjectArray();
        for (Product p : products) {
            System.out.println(p.toString());
        }
        //
        int[] mySimpleArray = practice.testSimpleArray();
        for (int v : mySimpleArray) {
            System.out.println(v);
        }

    }

    private int[] testSimpleArray() {
        int[] myArray = new int[]{1, 2, 3, 5};
        for (int i = 0; i < myArray.length; i++) {
            myArray[i] = (i + 1) * 100;
        }
        return myArray;
    }

    private Product[] testObjectArray() {
        int arrLength = 10;
        Product[] products = new Product[arrLength];
        for (int i = 0; i < arrLength; i++) {
            Product p = Product.builder().id(i).name("name" + i).price(i * 1.1).num(i).build();
            products[i] = p;
        }
        return products;
    }
}
