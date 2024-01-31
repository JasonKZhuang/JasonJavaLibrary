package com.jasonz.dto;

import java.util.Random;

/**
 * @author Jason Zhuang
 * @created 2024.01.24 17:52
 * @project JasonJavaLibrary
 * @description:
 */
public class ProductManager {

    public static Product[] initProductsArray(int count) {

        Product[] retArray = new Product[count];
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            retArray[i] =  Product.builder()
                    .id(i)
                    .name("name"+random.nextInt())
                    .price(random.nextDouble())
                    .num(random.nextInt())
                    .build();
        }
        return retArray;
    }
}
