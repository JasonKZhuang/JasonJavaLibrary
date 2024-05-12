package com.jasonz.exception;

import java.io.IOException;

public class MainSample {

    public static void main(String[] args) {
        MainSample sample = new MainSample();
        sample.testFinally();
    }

    private void testDivideZero() {
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


    private void testFinally() {
        class MyResource implements AutoCloseable {
            public void open() throws IOException {
                throw new IOException("open");
            }
            public void close() {
                throw new ArithmeticException("close");
            }
        }

        try (MyResource myResource = new MyResource()) {
            myResource.open();
            throw new NullPointerException("try");
        } catch (Exception e) {
            throw new IllegalArgumentException("catch");
        } finally {
            throw new ClassCastException("finally");
        }
    }


}
