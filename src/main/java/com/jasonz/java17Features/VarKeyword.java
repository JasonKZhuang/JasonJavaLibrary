package com.jasonz.java17Features;

import com.jasonz.dto.Product;
import com.jasonz.service.PrepareData;
import lombok.NonNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Jason Zhuang
 * @created 2023.11.16 13:01
 * @project JasonJavaLibrary
 * @description:
 */
public class VarKeyword {
    public static void main(String[] args) {

    }

    /**
     * the declaration it’s much, much shorter
     */
    public void example1(){
        // java 8 way
        Map<String, List<Product>> myMap = new HashMap<String, List<Product>>();
//        List<MyDomainObjectWithLongName> myList = aDelegate.fetchDomainObjects();

        // java 17 way
        var myMapNew = new HashMap<String, List<Product>>();
//        var myList = aDelegate.fetchDomainObjects();

        boolean isThereVolvo = PrepareData.getListOfProducts().stream()
                .anyMatch((@NonNull var p) -> p.getName().equalsIgnoreCase("Volvo"));
        System.out.println(isThereVolvo);
    }
}
