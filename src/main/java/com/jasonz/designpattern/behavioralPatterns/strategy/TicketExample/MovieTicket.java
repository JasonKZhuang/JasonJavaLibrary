package com.jasonz.designpattern.behavioralPatterns.strategy.TicketExample;

import lombok.Data;

/**
 * @author : Jason Zhuang
 * @date : 14/4/2022
 * @description :
 */
public class MovieTicket {
    private double price;
    private IDiscount discount;

    public MovieTicket(){}

    public MovieTicket(double price){
        this.price = price;
    }
    public double getPrice() {
        return discount.calculate(this.price);
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public IDiscount getDiscount() {
        return discount;
    }

    public void setDiscount(IDiscount discount) {
        this.discount = discount;
    }
}
