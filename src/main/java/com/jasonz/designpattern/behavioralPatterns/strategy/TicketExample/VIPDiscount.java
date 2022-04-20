package com.jasonz.designpattern.behavioralPatterns.strategy.TicketExample;

/**
 * @author : Jason Zhuang
 * @date : 14/4/2022
 * @description :
 */
public class VIPDiscount implements IDiscount{
    @Override
    public double calculate(double price) {
        System.out.println("VIP票：");
        System.out.println("增加积分！");
        return price * 0.5;
    }
}
