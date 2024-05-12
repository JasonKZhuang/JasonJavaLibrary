package com.jasonz.oop.inheritance;

/**
 * @author Jason Zhuang
 * @created 2024.03.10 19:40
 * @project JasonJavaLibrary
 * @description:
 */
public class Sample {

    public  static void main(String[] args) {
        Invoice invoice = new SalesInvoice();
        System.out.println(invoice.formatIdStatic("1234"));
        System.out.println(invoice.formatIdNonStatic("1234"));
        

        // Invoice invoice2 = new Invoice();
        // System.out.println((SalesInvoice)Invoice.formatId("1234"));

        Invoice invoice2 = new Invoice();
        System.out.println(invoice2.formatIdStatic("1234"));
        System.out.println(invoice2.formatIdNonStatic("1234"));

        SalesInvoice invoice3 = new SalesInvoice();
        System.out.println(Invoice.formatIdStatic("1234"));
        //System.out.println(Invoice.formatIdNonStatic("1234"));

        SalesInvoice invoice4 = new SalesInvoice();
        System.out.println(invoice4.formatIdStatic("1234"));
        System.out.println(invoice4.formatIdNonStatic("1234"));
    }



}



