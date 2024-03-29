package com.jasonz.designpattern.behavioralPatterns.strategy;

/**
 * @author : Jason Zhuang
 * @date : 14/4/2022
 * @description :
 */
public class Client {

    public static void main(String args[]) {
        MovieTicket mt = new MovieTicket();
        double originalPrice = 60.0; //原始票价
        double currentPrice; //折后价

        mt.setPrice(originalPrice);
        System.out.println("原始价为：" + originalPrice);
        System.out.println("---------------------------------");

        mt.setType("student"); //学生票
        currentPrice = mt.calculate();
        System.out.println("折后价为：" + currentPrice);
        System.out.println("---------------------------------");

        mt.setType("children"); //儿童票
        currentPrice = mt.calculate();
        System.out.println("折后价为：" + currentPrice);
    }
}
