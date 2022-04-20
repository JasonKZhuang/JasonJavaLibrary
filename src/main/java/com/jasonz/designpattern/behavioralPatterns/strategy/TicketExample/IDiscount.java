package com.jasonz.designpattern.behavioralPatterns.strategy.TicketExample;

/**
 * @author : Jason Zhuang
 * @date : 14/4/2022
 * @description :
 */
public interface IDiscount {
    public double calculate(double price);
}
