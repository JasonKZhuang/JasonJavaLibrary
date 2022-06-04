package com.jasonz.excercise;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class SearchMuch {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 2, 2, 2, 3, 4, 5, 6, 6, 6, 4, 3, 1};
        candidate(arr);
    }


    public static void candidate(int[] array)    // 找出数组中出现次数最多的那个数
    {
        // map的key存放数组中的数字，value存放该数字出现的次数
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i])) {
                int formerValue = map.get(array[i]);
                map.put(array[i], formerValue + 1);    // 该数字出现的次数加1
            } else {
                map.put(array[i], 1);    // 该数字第一次出现
            }
        }

        Collection<Integer> count = map.values();
        // 找出map的value中最大值，也就是数组中出现最多的数字所出现的次数
        int maxCount = Collections.max(count);
        int maxNumber = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            //得到value为maxCount的key，也就是数组中出现次数最多的数字
            if (entry.getValue() == maxCount) {
                maxNumber = entry.getKey();
            }
        }
        System.out.println("出现次数最多的数字为：" + maxNumber);
        System.out.println("该数字一共出现" + maxCount + "次");
    }
}