package com.jasonz.oop.inheritance;

public class SalesInvoice extends Invoice {
    public static String formatIdStatic(String oldId) {
        return oldId + "_ChildInvoice_Static";
    }

    public String formatIdNonStatic(String oldId) {
        return oldId + "_ChildInvoice_NonStatic";
    }
}