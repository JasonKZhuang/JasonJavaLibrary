package com.jasonz.oop.inheritance.base;

class ParentClass {
    public int getMethod(int a, int b) {
        System.out.println("ParentClass");
        return 0;
    }

    protected int getLocalCode(String value, boolean isValidated){
        System.out.println("this is parent class");
        return 0;
    }
}

