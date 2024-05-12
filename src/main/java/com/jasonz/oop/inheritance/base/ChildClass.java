package com.jasonz.oop.inheritance.base;

class ChildClass extends ParentClass{
    public int getMethod(int a, int b) {
        System.out.println("ChildClass");
        return 0;
    }

    public static void main(String[] args) {
        ParentClass a1 = new ChildClass();
        a1.getMethod(1,2);

    }

//    @Override
//    protected int getLocalCode(String value, boolean isValidated) {
//        return super.getLocalCode(value, isValidated);
//    }

    @Override
    public int getLocalCode(String value, boolean isValidated) {
        return super.getLocalCode(value, isValidated);
    }
}