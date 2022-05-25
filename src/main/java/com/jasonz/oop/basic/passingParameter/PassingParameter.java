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
        instance.testPassingByValue(arg);
        System.out.println("In Main Function:" + arg);
        System.out.println("================================");
        //===
        String productName = "Car";
        instance.testPassingByString(productName);
        System.out.println("In Main Function:" + productName);
        System.out.println("================================");
        //===
        Product product = new Product();
        product.setName("Car");
        instance.testPassingByClass(product);
        System.out.println("In Main Function:" + product.getName());
        System.out.println("================================");
        //==
        product.setName("Car");
        instance.testPassingByClassNew(product);
        System.out.println("In Main Function:" + product.getName());
        System.out.println("================================");

    }

    /**
     * passing by primitive variable, copy the value
     *
     * @param arg
     */
    private void testPassingByValue(int arg) {
        arg = 100;
        System.out.println("In Test Function:" + arg);
    }

    /**
     * still is a copy
     * @param arg
     */
    private void testPassingByString(String arg) {
        arg = "Train";
        System.out.println("In Test Function:" + arg);
    }

    /**
     * passing the Product memory address
     * @param arg
     */
    private void testPassingByClass(Product arg) {
        arg.setName("Train");
        System.out.println("In Test Function:" + arg.getName());
    }

    /**
     * passing the Product memory address
     * @param arg
     */
    private void testPassingByClassNew(Product arg) {
        arg.setName("Train");

        // new operation means create a memory block with new address
        arg = new Product();
        arg.setName("Ship");
        System.out.println("In Test Function:" + arg.getName());
    }

}
