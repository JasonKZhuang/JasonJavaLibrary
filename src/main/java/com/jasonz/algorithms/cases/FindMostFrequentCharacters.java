package com.jasonz.algorithms.cases;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.*;

/**
 * @author Jason Zhuang
 * @created 2023.11.25 18:43
 * @project JasonJavaLibrary
 * @description:
 */
public class FindMostFrequentCharacters {

    public static void main(String[] args) {
        final String INPUT1 = "aaaaaaaaaa(10) bbbbbbb ccccc dddd eee ff";
        FindMostFrequentCharacters mySelf = new FindMostFrequentCharacters();
        System.out.println(mySelf.searchByStream(INPUT1));
        System.out.println(mySelf.searchByMap(INPUT1));
        System.out.println(mySelf.searchByBucket(INPUT1));

    }

    /**
     * magic method
     * @param input
     * @return
     */
    public Character searchByStream(String input) {

        Map<Character, Long> charCounts = input.chars()//break the input string into an IntStream
                .mapToObj(c -> (char) c) // cast the integer to char and “box” it to Character
                .filter(Character::isLetterOrDigit)
                .collect(groupingBy(c -> c, counting())); // group by Characters, counting() the occurrences, and collect them as Map<Character, Long>

        Optional<Map.Entry<Character, Long>> maxEntry = charCounts
                .entrySet()
                .stream() // create a stream of all map entries
                .max(comparingByValue());   // find the maximal entry by the entry’s value.

        // get the entry’s key, which is the Character object with the maximal times of occurrences
        return maxEntry.map(Map.Entry::getKey).orElseThrow();

    }

    public Set<Character> searchByMap(String input) {
        Map<Character, Integer> map = new HashMap<>();

        // the Map.compute() method to simplify the implementation of
        // “If a key (Character) exists, increment its value,
        //  otherwise create an entry: theCharacter: 1“.
        for (char c : input.toCharArray()) {
            map.compute(c, (character, count) -> count == null ? 1 : ++count);
        }

        int maxCount = map.values()
                .stream()
                .mapToInt(Integer::intValue)
                .max()
                .getAsInt();

        return map.keySet()
                .stream()
                .filter(c -> map.get(c) == maxCount)
                .collect(toSet());
    }

    /**
     * We know that the ASCII character set consists of 128 characters.
     * Also, the ASCII codes of all these 128 characters range from 0 to 127.
     * Therefore, we can initialize an int[] array with 128 elements (buckets).
     * The array indexes are from 0 to 127, which covers all ASCII characters’ ASCII codes.
     *
     * @param input
     * @return the overall time complexity of the provided code is O(n), where n is the length of the input string.
     */
    public Set<Character> searchByBucket(String input) {
        int[] buckets = new int[128];

        int maxCount = 0;
        for (char c : input.toCharArray()) {
            buckets[c]++;
            maxCount = Math.max(buckets[c], maxCount);
        }

        int finalMaxCount = maxCount;
        return IntStream.range(0, 128)
                .filter(c -> buckets[c] == finalMaxCount)
                .mapToObj(i -> (char) i)
                .collect(Collectors.toSet());
    }

}
