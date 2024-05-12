package com.jasonz.java8Features.streamAPI;

import com.jasonz.java8Features.streamAPI.bean.Gender;
import com.jasonz.java8Features.streamAPI.bean.PersonObject;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.ToDoubleFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Jason Zhuang
 * @created 2024.03.09 18:04
 * @project JasonJavaLibrary
 * @description:
 */
public class UsingCollectorsMethods {
    public static void main(String[] args) {
        UsingCollectorsMethods ins = new UsingCollectorsMethods();
        // ins.handleGroupingBy();
        // ins.handleToMap();
    }

    private void handleOtherMethods() {
        PersonObject s1 = new PersonObject("Alice", "Business", 17.0);
        PersonObject s2 = new PersonObject("Bob", "Business", 19.0);
        PersonObject s3 = new PersonObject("Christine", "Engineering", 8.0);
        PersonObject s4 = new PersonObject("Daniel", "Engineering", 8.0);
        List<PersonObject> people = List.of(s1, s2, s3, s4);

        // Accumulate names into a List
        List<String> list = people.stream()
                .map(PersonObject::getName)
                .collect(Collectors.toList());

        // Accumulate names into a TreeSet
        Set<String> set = people.stream()
                .map(PersonObject::getName)
                .collect(Collectors.toCollection(TreeSet::new));

        // Convert elements to strings and concatenate them, separated by commas
        List<Integer> ages = List.of(100, 20, 30, 50);
        String joined = ages.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", "));

        // Compute sum of marks of everyone
        int total = people.stream().mapToInt(PersonObject::getAge).sum();

        // Group employees by Faculty
        Map<String, List<PersonObject>> byDept = people.stream()
                .collect(Collectors.groupingBy(PersonObject::getFaculty));

        // Compute sum of salaries by department
        //        Map<Department, Integer> totalByDept = employees.stream()
        //                .collect(Collectors.groupingBy(Employee::getDepartment,
        //                        Collectors.summingInt(Employee::getSalary)));
        //
        //        // Partition students into passing and failing
        //        Map<Boolean, List<Student>> passingFailing = students.stream()
        //                .collect(Collectors.partitioningBy(s -> s.getGrade() >= PASS_THRESHOLD));
    }

    public void handleGroupingBy() {

        PersonObject s1 = new PersonObject("Alice", "Business", 17.0);
        PersonObject s2 = new PersonObject("Bob", "Business", 19.0);
        PersonObject s3 = new PersonObject("Christine", "Engineering", 8.0);
        PersonObject s4 = new PersonObject("Daniel", "Engineering", 8.0);

        // steamlising
        Stream<PersonObject> stream = Stream.of(s1, s2, s3, s4);

        // assign a functional interface
        ToDoubleFunction<PersonObject> toDoubleFunction = PersonObject::getMark;

        // group records return a Map via Collectors.groupingBy()
        Map<String, List<PersonObject>> students = stream.collect(Collectors.groupingBy(PersonObject::getFaculty));

        // loop this map
        students.forEach((key, val) -> {
            // using Collectors.averagingDouble()
            double ave = val.stream().collect(Collectors.averagingDouble(toDoubleFunction));
            System.out.println(ave);
        });
    }

    private void handleToMap() {
        PersonObject p1 = new PersonObject("Andrew", Gender.MALE);
        PersonObject p2 = new PersonObject("Beatrice", Gender.FEMALE);
        PersonObject p3 = new PersonObject("Chris", Gender.MALE);
        PersonObject p4 = new PersonObject("Diana", Gender.FEMALE);
        Stream<PersonObject> persons = Stream.of(p1, p2, p3, p4);

        // throw exception
        // Duplicate key MALE (attempted merging values Andrew and Chris)
        // Returns a Collector that accumulates elements into a Map whose keys and values are the result of applying the provided mapping functions to the input elements.
        // If the mapped keys contain duplicates (according to Object.equals(Object)),
        // an IllegalStateException is thrown when the collection operation is performed.
        // If the mapped keys might have duplicates, use toMap(Function, Function, BinaryOperator) instead.
        System.out.println(
                persons.collect(Collectors.toMap(p -> p.getGender(), p -> p.getName()))
        );
    }
}
