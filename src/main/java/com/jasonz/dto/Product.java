package com.jasonz.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

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
    private Date producedDate;
    private String description;
}
