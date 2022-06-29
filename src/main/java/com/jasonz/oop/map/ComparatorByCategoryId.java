package com.jasonz.oop.map;

import java.util.Comparator;

public class ComparatorByCategoryId implements Comparator<Category> {

    @Override
    public int compare(Category o1, Category o2) {
        return Integer.valueOf(o1.getCode()).compareTo(Integer.valueOf(o2.getCode()));
    }
}