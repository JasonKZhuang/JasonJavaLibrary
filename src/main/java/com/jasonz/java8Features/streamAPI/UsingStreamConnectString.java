package com.jasonz.java8Features.streamAPI;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author : Jason Zhuang
 * @date : 8/4/2022
 * @description :
 */
public class UsingStreamConnectString {
    public static void main(String[] args) {
        UsingStreamConnectString instance = new UsingStreamConnectString();
        List<String> strings = new ArrayList<>();
        strings.add("abc");
        strings.add("def");
        strings.add("xyz");
        instance.example1(strings);

        List<PersonObject> personList = new ArrayList<>();
        personList.add(new PersonObject("abc",10));
        personList.add(new PersonObject("bcd",20));
        personList.add(new PersonObject("xyz",30));
        instance.example2(personList);

    }

    private void example1(List<String> argStrings) {
        String out = argStrings.stream().map(Objects::toString).collect(Collectors.joining(" "));
        System.out.println(out);
    }

    private void example2(List<PersonObject> argPersons) {
        String outString = argPersons.stream().map(p-> "'"+p.getName()+"'").collect(Collectors.joining("-"));
        List<Integer> outAges = argPersons.stream().map(p-> p.getAge()).collect(Collectors.toList());
        System.out.println(outString);
        System.out.println(outAges);
    }

}
