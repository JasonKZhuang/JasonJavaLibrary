package com.jasonz.dataStructures.list.arrayList;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RemoveDuplicatesExample {
    public static void main(String[] args) {
        // Creating an ArrayList with duplicate elements
        List<String> stringListWithDuplicates = new ArrayList<>();
        stringListWithDuplicates.add("Apple");
        stringListWithDuplicates.add("Banana");
        stringListWithDuplicates.add("Orange");
        stringListWithDuplicates.add("Apple");
        stringListWithDuplicates.add("Grapes");
        stringListWithDuplicates.add("Banana");

        System.out.println("Original List with Duplicates: " + stringListWithDuplicates);

        // Using Stream.distinct() to remove duplicates
        List<String> stringListWithoutDuplicates = stringListWithDuplicates.stream()
                .distinct()
                .toList();

        System.out.println("List without Duplicates: " + stringListWithoutDuplicates);
    }
}
