package com.jasonz.oop.collection.list.vector;

/**
 * @author : Jason Zhuang
 * @date : 21/4/2022
 * @description :
 * ArrayList and Vectors both implement the List interface,
 * and both use (dynamically resizable) arrays for their internal data structure,
 * much like using an ordinary array.
 * https://www.geeksforgeeks.org/vector-vs-arraylist-java/
 *
 * Vectors are synchronised, ArrayLists are not. This means that if you plan on using concurrency (i.e. threads), then Vectors would be more appropriate.
 * Vector class is synchronised,whereas ARRAYList class is not synchorized
 *
 * The Vector class is thread-safe. Meaning that it is synchronized,
 * so you won't get a ConcurrentModificationException if you have multiple threads.
 * However, if you are working in a single-thread environment, use ArrayList to decrease overhead.
 *
 */
public class MainTestVector {
    public static void main(String[] args) {

    }
}
