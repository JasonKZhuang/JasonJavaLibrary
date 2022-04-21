package com.jasonz.oop.collection;

import java.util.*;

/**
 * @creator Jason Zhuang
 * @create-time 2013-7-17
 * copywrite kkcms.com
 */
public class Visitor {
    public static void print(Collection<? extends Object> c) {
        Iterator<? extends Object> it = c.iterator();
        while (it.hasNext()) {
            Object element = it.next();
            System.out.println(element);
        }
        System.out.println("------------------------------");
    }

    public static void main(String[] args) {
        Set<String> set = new HashSet<String>();
        set.add("Tom");
        set.add("Mary");
        set.add("Jack");
        print(set);

        List<String> lst = new ArrayList<String>();
        lst.add("Linda");
        lst.add("Jessica");
        lst.add("Rose");
        print(lst);

        Map<String, String> map = new HashMap<String, String>();
        map.put("M", "Jason");
        map.put("FM", "Mike");
        print(map.entrySet());
    }
}

