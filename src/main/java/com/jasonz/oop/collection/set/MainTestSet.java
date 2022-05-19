package com.jasonz.oop.collection.set;

import java.util.*;

/**
 * @creator Jason Zhuang
 * @create-time 2013-7-17 copywrite
 */
public class MainTestSet {
    public static void main(String[] args) {
        MainTestSet ss = new MainTestSet();
        ss.testingHashSet();
        ss.testingTreeSet();
        ss.testingHashMap();
    }

    /**
     * A HashSet is a collection of items where every item is unique,
     * but without sequence
     */
    private void testingHashSet() {
        // Set 集合存和取的顺序不一致。
        Set<String> hs = new HashSet<String>();
        try {
            hs.add("世界军事");
            hs.add("兵器知识");
            hs.add("舰船知识");
            hs.add("汉和防务");
            hs.add("汉和防务");
            System.out.println(hs);
            // [舰船知识, 世界军事, 兵器知识, 汉和防务]
            Iterator<String> it = hs.iterator();
            while (it.hasNext()) {
                System.out.println(it.next());
            }
        } catch (Exception exp) {
            exp.printStackTrace();
        }
        System.out.println("=================================================================");
    }

    private void testingTreeSet() {
        // Set 集合 存和取 的顺序不一致。
        // elements in set are sorted naturally
        // TreeSet implements SortedSet interface
        Set<String> hs = new TreeSet<String>();
        try {
            hs.add("Andy");
            hs.add("Jason");
            hs.add("Charly");
            hs.add("Bob");
            for (String v : hs) {
                System.out.println(v);
            }
        } catch (Exception exp) {
            exp.printStackTrace();
        }
        System.out.println("=================================================================");

        // elements in set are sorted by a new Comparator
        // TreeSet implements SortedSet interface
        TreeSet tsStudents = new TreeSet(new ComparatorByMarks());
        Student student;
        student = new Student("A",0,99.9f);
        tsStudents.add(student);
        student = new Student("B",0,89.9f);
        tsStudents.add(student);
        student = new Student("C",0,59.9f);
        tsStudents.add(student);
        student = new Student("D",0,70.9f);
        tsStudents.add(student);
        student = new Student("E",0,70.9f);
        tsStudents.add(student);
        for (Object s : tsStudents) {
            System.out.println(s);
        }
        System.out.println("=================================================================");

    }

    private void testingHashMap() {
        // Set 集合存和取的顺序不一致。
        Map<String, String> myMap = new HashMap<>();
        try {
            myMap.put("hello", "hello");
            myMap.put("Jason", "Jason");
            myMap.put("hello", "hello");
            Iterator<String> it = myMap.keySet().iterator();
            while (it.hasNext()) {
                System.out.println(it.next());
            }
        } catch (Exception exp) {
            exp.printStackTrace();
        }
        System.out.println("=================================================================");
    }
}
