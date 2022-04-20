package com.jasonz.designpattern.behavioralPatterns.strategy.TicketExample;

/**
 * @author : Jason Zhuang
 * @date : 14/4/2022
 * @description :
 */
public class StudentDiscount implements IDiscount{
    @Override
    public double calculate(double price) {
        System.out.println("学生票：");
        return price * 0.8;
    }
}
