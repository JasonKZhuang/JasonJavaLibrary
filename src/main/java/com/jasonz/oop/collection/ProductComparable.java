package com.jasonz.oop.collection;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : Jason Zhuang
 * @date : 23/4/2022
 * @description :
 */
public class ProductComparable extends Product implements Comparable<Product>{
    @Override
    public int compareTo(Product obj) {
        Integer selfId = Integer.valueOf(this.getId());
        Integer againstId = Integer.valueOf(obj.getId());
        // return selfId.compareTo(againstId); //ASC
        return againstId.compareTo(selfId); //DESC
    }
}
