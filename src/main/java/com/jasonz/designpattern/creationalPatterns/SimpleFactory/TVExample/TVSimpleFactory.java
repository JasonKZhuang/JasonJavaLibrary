package com.jasonz.designpattern.creationalPatterns.SimpleFactory.TVExample;

public class TVSimpleFactory {
    public static ITV produceTV(String brand) throws Exception {
        if (brand.equalsIgnoreCase("Haier")) {
            return new HaierTV();
        } else if (brand.equalsIgnoreCase("Hisense")) {
            return new HisenseTV();
        } else {
            throw new Exception("No input Brand" + brand);
        }
    }
}