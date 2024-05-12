package com.jasonz.oop.inheritance;

public class Invoice {
    public static String formatIdStatic(String oldId) {
        return oldId + "_Parent_Static";
    }

    public String formatIdNonStatic(String oldId) {
        return oldId + "_Parent_NonStatic";
    }
}