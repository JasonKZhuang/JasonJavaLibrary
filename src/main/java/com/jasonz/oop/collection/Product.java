package com.jasonz.oop.collection;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : Jason Zhuang
 * @date : 21/4/2022
 * @description :
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {
    protected int id;
    protected String name;
    protected double price;
    protected int num;
}
