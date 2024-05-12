package com.jasonz.dataStructures.collection.compare;

import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

/**
 * @author Jason Zhuang
 * @created 2024.03.10 09:15
 * @project JasonJavaLibrary
 * @description:
 */
class Data implements Comparable<Data>, Comparator<Data> {
    int number;

    Data(int number) {
        this.number = number;
    }

    public int compareTo(Data d) {
        return number - d.number;
    }

    public int compare(Data d1, Data d2) {
        return d2.number - d1.number;
    }
}

class Test {
    public static void main(String[] args) {
        Data d1 = new Data(2);
        Data d2 = new Data(3);
        Data d3 = new Data(1);
        TreeSet<Data> set = new TreeSet<>(d3);
        set.addAll(List.of(d1, d2, d3));
        int higherNumber = set.higher(d1).number;
        System.out.println(higherNumber);
    }

}