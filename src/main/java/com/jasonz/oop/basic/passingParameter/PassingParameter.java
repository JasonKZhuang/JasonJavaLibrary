package com.jasonz.oop.basic.passingParameter;

/**
 * @author : Jason Zhuang
 * @date : 25/5/2022
 * @description :
 */
public class PassingParameter {

    public static void main(String[] args) {
        PassingParameter instance = new PassingParameter();
        int arg = 200;
        System.out.println("In Main Function Primitive variable before : " + arg);
        instance.testPassingByValue(arg);
        System.out.println("In Main Function Primitive variable After : " + arg);
        System.out.println("=== passing Primitive value is a copy of variable========\n");

        //===
        String productName = "Car";
        System.out.println("In Main Function String variable Before : " + productName);
        instance.testPassingByString(productName);
        System.out.println("In Main Function String variable After : " + productName);
        System.out.println("=== Passing String value is a copy of variable=============\n");
        //===
        Product product = new Product();
        product.setName("Car");
        System.out.println("In Main Function Object variable Before : " + product.getName());
        instance.testPassingByClass(product);
        System.out.println("In Main Function Object variable After : " + product.getName());
        System.out.println("=== Passing an object is a Reference passing ==================\n");
        //==
        product.setName("Car");
        System.out.println("In Main Function Object variable Before Re-New Object: " + product.getName());
        instance.testPassingByClassNew(product);
        System.out.println("In Main Function Object variable After Re-New Object: " + product.getName());
        System.out.println(
                "=== Passing an object is a Reference Passing.\n" +
                "    Although inside method the object ws re-newed, \n" +
                "    the original product memory address does not change anymore \n" +
                "================================================================\n");
        //==
        int[] myIntArray = new int[]{1,2,3,4};
        System.out.println("In Main Function Array variable Before:" + myIntArray[0]);
        instance.testPassingByArray(myIntArray);
        System.out.println("In Main Function Array variable After:" + myIntArray[0]);
        System.out.println("== Passing an Array is a Reference Passing value changed will affect the original variable === ");

    }



    /**
     * passing by primitive variable, copy the value
     *
     * @param arg
     */
    private void testPassingByValue(int arg) {
        System.out.println("In Test Function original parameter :" + arg);
        arg = 100;
        System.out.println("In Test Function Change parameter to :" + arg);
    }

    /**
     * still is a copy
     * @param arg
     */
    private void testPassingByString(String arg) {
        System.out.println("In Test Function original parameter :" + arg);
        arg = "Train";
        System.out.println("In Test Function Change parameter to :" + arg);
    }

    /**
     * passing the Product memory address
     * @param arg
     */
    private void testPassingByClass(Product arg) {
        System.out.println("In Test Function original parameter :" + arg.getName());
        arg.setName("Train");
        System.out.println("In Test Function Change parameter to :" + arg.getName());
    }

    /**
     * passing the Product memory address
     * @param arg
     */
    private void testPassingByClassNew(Product arg) {
        System.out.println("In Test Function original parameter :" + arg.getName());
        // new operation means create a memory block with new address
        arg = new Product();
        arg.setName("Ship");
        System.out.println("In Test Function Change parameter to a new Product Object with new value : " + arg.getName());

    }

    private void testPassingByArray(int[] myIntArray) {
        System.out.println("In Test Function original parameter :" + myIntArray[0]);
        myIntArray[0] = 99;
        System.out.println("In Test Function Change parameter array[0] to a new value : " + myIntArray[0]);

    }

}
