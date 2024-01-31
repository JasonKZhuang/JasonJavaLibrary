package com.jasonz.dataStructures.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * @author Jason Zhuang
 * @created 2023.11.09 13:11
 * @project JasonJavaLibrary
 * @description:
 */
public class RemoveItemFromMapWhileIteration {

    public static void main(String[] args) throws Exception {
        // create a Map to demonstrate example
        // add some mapping e.g. popular Java books and their prices
        Map<String, Double> priceMap = new HashMap<String, Double>();
        priceMap.put("Effective Java", 41.79);
        priceMap.put("Head First Java", 29.02);
        priceMap.put("Java Concurrency In Practice", 30.67);
        priceMap.put("Java SE 8 for Really Impatient", 31.99);
        priceMap.put("Head First Design Pattern", 39.05);

        removeItemFromMapWhileIteration(priceMap);
    }

    public static void removeItemFromMapWhileIteration(Map<String, Double> argMap){
        // let's remove all books which are greater than 39.00 USD from map
        // get a set of entries
        Set<Entry<String, Double>> setOfEntries = argMap.entrySet();

        // get the iterator from entry set
        Iterator<Entry<String, Double>> iterator = setOfEntries.iterator();

        // iterate over map
        while (iterator.hasNext()) {
            Entry<String, Double> entry = iterator.next();
            Double value = entry.getValue();
            if (value.compareTo(Double.valueOf(39.00)) > 0) {
                System.out.println("removeing : " + entry);
                // priceMap.remove(entry.getKey()); // wrong - will throw ConcurrentModficationException
                // priceMap.remove(entry.getKey(), entry.getValue()); // wrong - will throw error
                iterator.remove();  // always use remove() method of iterator
            }
        }
    }
}
