package com.jasonz.dataStructures.map;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

/**
 * @author Jason Zhuang
 * @created 2024.03.10 11:06
 * @project JasonJavaLibrary
 * @description:
 */


public class BiConsumerExample {
    public static void main(String[] args) {
        // 创建一个Map实例
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "苹果");
        map.put(2, "香蕉");
        map.put(3, "橘子");

        // 使用forEach方法遍历Map
        map.forEach(new BiConsumer<Integer, String>() {
            @Override
            public void accept(Integer key, String value) {
                System.out.println("键: " + key + ", 值: " + value);
            }
        });

        // 或者，使用Lambda表达式简化代码
        map.forEach(
                (key, value) -> System.out.println("键: " + key + ", 值: " + value)
        );
    }
}
