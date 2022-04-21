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
        //é��åŽ†é›†å�ˆä¸­æ‰€æœ‰å…ƒç´ 
        while (it.hasNext()) {
            Object element = it.next();
            System.out.println(element);
        }
        System.out.println("------------------------------");
    }

    public static void main(String[] args) {
        //ä¸�é‡�å¤�ï¼Œä¸�æŽ’åº�ï¼Œä¸»è¦�2ä¸ªå®žçŽ°ç±»HashSetå’ŒTreeSet
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
        map.put("M", "ç”·");
        map.put("FM", "å¥³");
        print(map.entrySet());


        //å½“æœ‰ä¸¤ä¸ªçº¿ç¨‹å�Œæ—¶æ“�ä½œä¸€ä¸ªé›†å�ˆæ—¶ï¼Œä¸€ä¸ªçº¿ç¨‹è¯»å�–ï¼Œä¸€ä¸ªçº¿ç¨‹ä¿®æ”¹
        //ä¼šæŠ›å‡ºå¼‚å¸¸ConcurrentModificationException

    }
}

