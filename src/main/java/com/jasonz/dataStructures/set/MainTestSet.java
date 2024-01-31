package com.jasonz.dataStructures.set;

import java.util.*;

/**
 * @creator Jason Zhuang
 * @create-time 2013-7-17 copywrite
 */
public class MainTestSet {
    public static void main(String[] args) {
        MainTestSet test = new MainTestSet();
        test.testingHashSet();
        test.testingTreeSet();
    }

    /**
     * A HashSet is a collection of items where every item is unique,
     * but without sequence
     */
    private void testingHashSet() {
        // Set 集合 存和取 的顺序不一致。
        Set<String> hs = new HashSet<String>();
        try {
            // the add method is actually using map.put() method
            // map.put(e, PRESENT)==null;
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

        Set<Student> students = new HashSet<Student> ();
        Student student1 = new Student("A",18,123.9f);
        Student student2 = new Student("B",20,456.9f);
        Student student3 = new Student("B",20,456.9f);
        System.out.println(student1.hashCode());
        System.out.println(student2.hashCode());
        System.out.println(student3.hashCode());

        students.add(student1);
        students.add(student2);
        // must overide the object hashcode method
        // because the add method is to call map.put()
        // the map.put() is to compare the object hash code using hash() function to determine the hash key in the map
        students.add(student3);

        for (Student s : students) {
            System.out.println(s);
        }
        System.out.println("=================================================================");
    }

    /**
     *  Set 集合 存和取 的顺序不一致。
     *  elements in set are sorted naturally
     *  TreeSet implements SortedSet interface
     */
    private void testingTreeSet() {

        Set<String> hs = new TreeSet<String>();
        try {
            hs.add("Andy");
            hs.add("Jason");
            hs.add("Charly");
            hs.add("Bob");
            hs.add("Jason");
            hs.add("Jason");
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


}
