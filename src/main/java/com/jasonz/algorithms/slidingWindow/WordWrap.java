package com.jasonz.algorithms.slidingWindow;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Jason Zhuang
 * @created 2024.01.28 23:47
 * @project JasonJavaLibrary
 * @description: We are building a word processor and we would like to implement a "word-wrap" functionality.
 * <p>
 * Given a list of words followed by a maximum number of characters in a line, return a collection of strings where each string element represents a line that contains as many words as possible, with the words in each line being concatenated with a single '-' (representing a space, but easier to see for testing). The length of each string must not exceed the maximum character length per line.
 * <p>
 * Your function should take in the maximum characters per line and return a data structure representing all lines in the indicated max length.
 * <p>
 * Examples:
 * <p>
 * words1 = [ "The", "day", "began", "as", "still", "as", "the",
 * "night", "abruptly", "lighted", "with", "brilliant",
 * "flame" ]
 * <p>
 * wrapLines(words1, 13) "wrap words1 to line length 13" =>
 * <p>
 * [ "The-day-began",
 * "as-still-as",
 * "the-night",
 * "abruptly",
 * "lighted-with",
 * "brilliant",
 * "flame" ]
 * <p>
 * wrapLines(words1, 12) "wrap words1 to line length 12" =>
 * <p>
 * [ "The-day",
 * "began-as",
 * "still-as-the",
 * "night",
 * "abruptly",
 * "lighted-with",
 * "brilliant",
 * "flame" ]
 * *
 * wrapLines(words1, 20) "wrap words1 to line length 20" =>
 * <p>
 * [ "The-day-began-as",
 * "still-as-the-night",
 * "abruptly-lighted",
 * "with-brilliant-flame" ]
 * <p>
 * words2 = [ "Hello" ]
 * <p>
 * wrapLines(words2, 5) "wrap words2 to line length 5" =>
 * <p>
 * [ "Hello" ]
 * <p>
 * <p>
 * wrapLines(words2, 30) "wrap words2 to line length 30" =>
 * <p>
 * [ "Hello" ]
 * <p>
 * words3 = [ "Hello", "Hello" ]
 * <p>
 * wrapLines(words3, 5) "wrap words3 to line length 5" =>
 * <p>
 * [ "Hello",
 * "Hello" ]
 * <p>
 * words4 = ["Well", "Hello", "world" ]
 * <p>
 * wrapLines(words4, 5) "wrap words4 to line length 5" =>
 * <p>
 * [ "Well",
 * "Hello",
 * "world" ]
 * <p>
 * words5 = ["Hello", "HelloWorld", "Hello", "Hello"]
 * <p>
 * wrapLines(words5, 20) "wrap words 5 to line length 20 =>
 * <p>
 * [ "Hello-HelloWorld",
 * "Hello-Hello" ]
 * <p>
 * <p>
 * words6 = [ "a", "b", "c", "d" ]
 * wrapLines(words6, 20) "wrap words 6 to line length 20 =>
 * <p>
 * [ "a-b-c-d" ]
 * <p>
 * wrapLines(words6, 4) "wrap words 6 to line length 4 =>
 * <p>
 * [ "a-b",
 * "c-d" ]
 * <p>
 * wrapLines(words6, 1) "wrap words 6 to line length 1 =>
 * <p>
 * [ "a",
 * "b",
 * "c",
 * "d" ]
 * <p>
 * All Test Cases:
 * words,  max line length
 * wrapLines(words1, 13)
 * wrapLines(words1, 12)
 * wrapLines(words1, 20)
 * wrapLines(words2, 5)
 * wrapLines(words2, 30)
 * wrapLines(words3, 5)
 * wrapLines(words4, 5)
 * wrapLines(words5, 20)
 * wrapLines(words6, 20)
 * wrapLines(words6, 4)
 * wrapLines(words6, 1)
 * <p>
 * n = number of words OR total characters
 */
public class WordWrap {


    public static void main(String[] args) {
        double v = 3.3;
        System.out.println(Math.floor(v));
        System.out.println(Math.ceil(v));

        v = -3.3;
        System.out.println(Math.floor(v));
        System.out.println(Math.ceil(v));

        String[] words1 = {
                "The", "day", "began", "as", "still",
                "as", "the", "night", "abruptly", "lighted",
                "with", "brilliant", "flame"
        };

        String[] words2 = {"Hello"};
        String[] words3 = {"Hello", "Hello"};
        String[] words4 = {"Well", "Hello", "world"};
        String[] words5 = {"Hello", "HelloWorld", "Hello", "Hello"};
        String[] words6 = {"a", "b", "c", "d"};

        List<String> lst1 = solutionArrayDeque(words1, 13);

        List<String> lst2 = solutionLinkedList(words1, 13);

        for (String s : lst1) {
            System.out.println(s);
        }
        System.out.println("==============================");
        for (String s : lst2) {
            System.out.println(s);
        }

    }

    private static List<String> solutionArrayDeque(String[] argString, int k) {
        List<String> retList = new ArrayList<>();
        // first in first out
        // if the before pushed element string is not met condition, we need to kick it out
        ArrayDeque<String> deque = new ArrayDeque<>();
        // 3>>2>>>1
        for (int i = 0; i < argString.length; i++) {

            // add to the end of array queue,
            // same as addLast, add to index(length)
            deque.add(argString[i]);

            // inserts the element at the front of this deque
            // same as addFirst, add to index=0
            // deque.push(argString[i]);

            int lenSum = calculateLength(deque);
            if (lenSum > k) {
                String lastElement = deque.removeLast();
                retList.add(String.join("-",deque));
                deque.clear();
                deque.add(lastElement);
            }
        }

        if (!deque.isEmpty()) {
            retList.add(String.join("-",deque));
        }

        return retList;
    }

    private static List<String> solutionLinkedList(String[] argString, int k) {
        List<String> ret = new ArrayList<>();
        LinkedList<String> lst = new LinkedList<>();

        for (int i = 0; i < argString.length; i++) {
            lst.add(argString[i]);
            int lenSum = calculateLength(lst);
            if (lenSum > k) {
                lst.removeLast();
                addToList(ret, lst);
                lst.clear();
                lst.add(argString[i]);
            }
        }

        if (!lst.isEmpty()) {
            addToList(ret, lst);
        }

        return ret;
    }

    private static int calculateLength(LinkedList<String> argData) {
        int len = 0;
        for (int i = 0; i < argData.size(); i++) {
            len = len + argData.get(i).length();
        }
        return len + argData.size() - 1;
    }

    private static int calculateLength(ArrayDeque<String> argData) {
        AtomicInteger len = new AtomicInteger();
        argData.forEach(e-> len.set(len.get() + e.length()));
        return len.get() + argData.size() -1;
    }

    private static void addToList(List<String> argRet, LinkedList<String> argData) {
        argRet.add(String.join("-", argData));
    }

    private static void addToList(List<String> argRet, ArrayDeque<String> argData) {
        argRet.add(String.join("-", argData));
    }

}
