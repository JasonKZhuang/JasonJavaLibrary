package com.jasonz.designpattern.behavioralPatterns.strategy.TicketExample;

/**
 * @author : Jason Zhuang
 * @date : 14/4/2022
 * @description :
 */
public class ClientTest {
    public static void main(String[] args){
        MovieTicket movieTicket = new MovieTicket(100D);
        IDiscount discount;

        discount = new ChildrenDiscount();
        movieTicket.setDiscount(discount);
        System.out.println( movieTicket.getPrice());
        System.out.println( "=================================");

        discount = new StudentDiscount();
        movieTicket.setDiscount(discount);
        System.out.println( movieTicket.getPrice());
        System.out.println( "=================================");

        discount = new VIPDiscount();
        movieTicket.setDiscount(discount);
        System.out.println( movieTicket.getPrice());
        System.out.println( "=================================");

    }
}
