package com.jasonz.systems;

import com.jasonz.dto.Book;

/**
 * @author Jason Zhuang
 * @created 2025.07.10 18:25
 * @project JasonJavaLibrary
 * @description:
 */
public class MemoryManagementExample {

    public static void main(String[] args) {
        int primitiveVariable1 = 42; // Primitive type stored in stack
        Book book = new Book("Harry Potter", 123.45D); // Reference type stored in stack, object in heap
        String stringLiteral = "Hello"; // String literal saved in the String pool in heap
        MemoryManagementExample example = new MemoryManagementExample(); // Instance of MemoryManagementExample stored in heap
        example.memoryManagementTest(book); // Call to a method that could demonstrate memory management concepts
    }

    private void memoryManagementTest(Book argBook) {
        Book book = argBook;
        String stringLiteral2 = "World"; // Another string literal in the String pool
        String stringLiteral3 = new String ("New World"); // New String object in heap
    }
}
