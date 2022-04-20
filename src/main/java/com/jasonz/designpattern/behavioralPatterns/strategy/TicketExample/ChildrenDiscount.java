package com.jasonz.designpattern.behavioralPatterns.strategy.TicketExample;

/**
 * @author : Jason Zhuang
 * @date : 14/4/2022
 * @description :
 */
public class ChildrenDiscount implements IDiscount{
    @Override
    public double calculate(double price) {
        System.out.println("儿童票：");
        return price - 10;
    }
}
