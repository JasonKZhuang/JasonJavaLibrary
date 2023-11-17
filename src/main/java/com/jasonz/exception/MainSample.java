package com.jasonz.exception;

public class MainSample {

    public static void main(String[] args) {
        int a = 1;
        int b = 0;
        try {
            int c = a / b;
        } catch (Exception exp) {

            exp.printStackTrace();
        }
    }

    public Double getSurcharge(Double transaction) {
        System.out.println("Surcharge Caliculation begins");
        System.out.println("Surcharge amount " + transaction);
        if (Double.isNaN(transaction)) {
            System.out.println(transaction + " is not a valid amount");
            throw new RuntimeException("Invalid Transaction");
        }
        return Math.PI;
    }


}
