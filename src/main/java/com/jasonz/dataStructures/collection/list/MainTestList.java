package com.jasonz.dataStructures.collection.list;

import com.jasonz.oop.inheritance.BaseAnimal;
import com.jasonz.oop.inheritance.children.Elephant;

import java.util.ArrayList;
import java.util.List;

/**
 * @creator Jason Zhuang
 * @create-time 2021-7-17
 * copywrite zhuangkaizhi.com
 */
public class MainTestList {

    public static void main(String[] args) {
        MainTestList instance = new MainTestList();
        instance.testArrayList();
    }

    private void testArrayList() {
        List<BaseAnimal> myList = new ArrayList<BaseAnimal>();
        Elephant obj = new Elephant();
        myList.add(obj);
    }

}

