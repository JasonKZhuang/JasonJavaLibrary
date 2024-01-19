package com.jasonz.java8Features.streamAPI;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
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
 * A stream is not a data structure instead it takes input from the Collections, Arrays or I/O channels.
 * Streams don’t change the original data structure, they only provide the result as per the pipelined methods.
 * Each intermediate operation is lazily executed and returns a stream as a result,
 * hence various intermediate operations can be pipelined.
 * Terminal operations mark the end of the stream and return the result.
 * @author Jason Zhuang 23 Jun. 2021
 */
public class UsingStreamAPI {

    public static void main(String[] args) {
        UsingStreamAPI api = new UsingStreamAPI();
        api.usingStreamFilter();
        api.usingStreamMap();
        //api.generateStream();
        //api.forEachStream();
        //api.collectOnePropertyListFromObjectList();
    }

    private List<PersonObject> constructDummyData(){
        // prepare dummy data
        List<PersonObject> persons = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            PersonObject p = new PersonObject("Name" + i, i + 20);
            if (i % 2 == 0) {
                p.setSeniorEngineer(true);
            }
            persons.add(p);
        }
        return persons;
    }

    /**
     * using Intermediate Operations: filter
     * The filter() function of the Java stream allows you to narrow down the stream's items based on a criterion.
     */
    private void usingStreamFilter() {
        // construct dummy data
        List<PersonObject> persons = constructDummyData();

        //using filter only keep elements which are subject the condition
        //只留下符合条件的记录，剔除不符合条件的记录
        List<PersonObject> newPersons = persons.stream()
                .filter(p -> p.getAge() > 22)
                .filter(PersonObject::isSeniorEngineer)
                .toList();
        newPersons.forEach(p -> System.out.println(p.toString()));
    }

    /**
     * using Intermediate Operations: Sorted
     */
    private void usingStreamSorted(){
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        List<String> sortedNames = names.stream()
                .sorted()
                .toList();
    }

    /**
     * using Intermediate Operations: map
     */
    private void usingStreamMap() {

        List<PersonObject> persons = constructDummyData();

        // 1. Simple One : Change a List of Strings to Uppercase
        List<String> alpha = Arrays.asList("a", "b", "c", "d");
        System.out.println(alpha); //[a, b, c, d]
        // Before Java 8
        List<String> alphaUpper = new ArrayList<>();
        for (String s : alpha) {
            alphaUpper.add(s.toUpperCase());
        }
        System.out.println(alphaUpper); //[A, B, C, D]
        // Now Java 8
        List<String> collect = alpha.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println(collect); //[A, B, C, D]


        // 2. From List of Objects -> List of String
        // 2.1.One line lambda function
        List<String> newList1 = persons.stream().map(PersonObject::getName).toList();
        // 2.1.2 Multiple lines code in lambda function
        List<String> newList = persons.stream().map(p -> {
            String ret = p.getName() + p.getAge();
            return ret;
        }).toList();

        // 3. From List of objects -> New List of other objects
        AtomicInteger employeeId = new AtomicInteger();
        List<EmployeeObject> result = persons.stream()
                .map(temp -> {
                    EmployeeObject obj = new EmployeeObject();
                    obj.setEmployeeId(Long.valueOf(employeeId.getAndIncrement()));
                    obj.setFirstName(temp.getName());
                    obj.setLastName(temp.getName());
                    obj.setDateOfBirth(new Date() );
                    obj.setPermanent(obj.getEmployeeId() % 2 == 0);
                    return obj;
                })
                .toList();
        result.forEach(e -> System.out.println(e.toString()));
    }

    /**
     * using Intermediate Operations: flatMap
     * (https://mkyong.com/java8/java-8-flatmap-example/)
     */
    private void usingStreamFlatMap(){
        List<PersonObject> persons = constructDummyData();
    }

    // Terminal Operations
    // 1. Foreach
    private void usingStreamForeach() {
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
    // 2. collect
    private void usingStreamCollect() {
        List<PersonObject> persons = constructDummyData();
    }
    // 3. reduce
    private void usingStreamReduce() {
        List<PersonObject> persons = constructDummyData();
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
