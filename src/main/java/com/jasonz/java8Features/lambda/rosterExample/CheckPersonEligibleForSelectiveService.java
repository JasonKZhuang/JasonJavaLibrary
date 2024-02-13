package com.jasonz.java8Features.lambda.rosterExample;

import com.jasonz.dto.Person;

public class CheckPersonEligibleForSelectiveService implements ICheckPerson {

    // implement test method of ICheckPerson interface
    public boolean test(Person p) {
        return p.getGender() == Person.Sex.MALE
                && p.getAge() >= 18
                && p.getAge() <= 25;
    }
}