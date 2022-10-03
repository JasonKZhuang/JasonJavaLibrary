/**
 * Project: JasonJavaLibrary
 * Date: 3/10/2022
 * Author: Jason
 */
package com.jasonz.reflect;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {
    private int id;
    private String name;
    private float price;
    private String content;
}
