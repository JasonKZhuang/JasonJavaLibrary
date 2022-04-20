package com.jasonz.java8Features.streamAPI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Reference: https://www.journaldev.com/2774/java-8-stream
 * A new java.util.stream has been added in Java 8 to perform filter/map/reduce like operations with the collection.
 * Stream API will allow sequential as well as parallel execution. (序列与并行操作)
 * people work a lot with Collections and usually with Big Data, we need to filter out them based on some conditions.
 * <p>
 * Collection interface has been extended with stream() and parallelStream() default methods
 * to get the Stream for sequential and parallel execution.
 *
 * @author Jason Zhuang 23 Jun. 2021
 */
public class UsingStreamAPI {

    public static void main(String[] args) {
        UsingStreamAPI api = new UsingStreamAPI();
        // api.generateStream();
        api.forEachStream();

    }

    private void forEachStream() {
        Random random = new Random();
        random.ints().limit(10).forEach(System.out::println);


        List<String> list = Arrays.asList("A", "B", "C", "D");
        //The most straightforward way is using the enhanced for-loop
        for (String s : list) {
            System.out.println(s);
        }

        // Collection.forEach() uses the collection's iterator, so the processing order of the items is defined.
        // In contrast, the processing order of Collection.stream().forEach() is undefined.

        // We can do so directly on the collection
        Consumer<String> consumer = s -> {
            System.out.println("do something with " + s);
        };
        list.forEach(consumer);

        // we can call forEach() on the collection's stream
        list.stream().forEach(consumer);
        System.out.println("=============================");

        // Parallel Streams
        list.forEach(System.out::print);
        System.out.print(" ");
        list.parallelStream().forEach(System.out::print);
        System.out.println("\n=============================");
    }

    private void generateStream() {
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        Stream<String> filtered = strings.stream().filter(string -> !string.isEmpty());
        List<String> filtered2 = filtered.collect(Collectors.toList());
        int i = 0;
        filtered.forEach((item) -> {

            System.out.println(item);
        });
    }

    private void practice() {
        List<Integer> myList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            myList.add(i);
        }

        // sequential stream
        Stream<Integer> sequentialStream = myList.stream();
        Stream<Integer> highNumsSeq = sequentialStream.filter(p -> p > 90);
        highNumsSeq.forEach(p -> System.out.println("High Nums sequential=" + p));
        //or we can write code as follow
        myList.stream()
                .filter(p -> p > 90)
                .forEach(p -> System.out.println("High Nums sequential=" + p));

        System.out.println("===================================================");


        // Notice that parallel processing values are not in order,
        //so parallel processing will be very helpful while working with huge collections.
        // parallel stream
        Stream<Integer> parallelStream = myList.parallelStream();
        // using lambda with Stream API, filter example
        Stream<Integer> highNums = parallelStream.filter(p -> p > 90);
        // using lambda in forEach
        highNums.forEach(p -> System.out.println("High Nums parallel=" + p));

        //or we can write code as follow
        myList.parallelStream()
                .filter(p -> p > 90)
                .forEach(p -> System.out.println("High Nums parallel=" + p));
        System.out.println("===================================================");

    }
}