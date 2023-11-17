package com.jasonz.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * @author Jason Zhuang
 * @created 2023.11.16 13:02
 * @project JasonJavaLibrary
 * @description:
 */
@Data
@Builder
public class Product {
    private long id;
    private String name;
    private float price;
    private Date producedDate;
    private String description;

}