package com.jasonz.service;

import com.jasonz.dto.Product;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Jason Zhuang
 * @created 2023.11.16 13:12
 * @project JasonJavaLibrary
 * @description:
 */
public class PrepareData {

    public static List<Product> getListOfProducts(){
        var products = new ArrayList<Product>();
        var product1 = Product.builder()
                .id(1)
                .name("Toyota")
                .price(123.456f)
                .description("Good brand car")
                .producedDate(new Date())
                .build();
        products.add(product1);

        var product2 = Product.builder()
                .id(2)
                .name("Mercedes-Benz")
                .price(32123.456f)
                .description("Good brand car")
                .producedDate(new Date())
                .build();
        products.add(product2);

        var product3 = Product.builder()
                .id(3)
                .name("Volvo")
                .price(32167.456f)
                .description("Good brand car")
                .producedDate(new Date())
                .build();
        products.add(product2);


        return products;
    }
}
