package com.jasonz;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Jason Zhuang
 * @created 2024.04.17 19:37
 * @project JasonJavaLibrary
 * @description:
 */
public class Task {
    public static void main(String[] args) {

        // sorting by utilizing treemap features
        TreeMap<Integer, String> wordsMap = new TreeMap<>();
        wordsMap = readFile("data.txt");

        // only need index
        int i = 0;
        int[] keys = new int[wordsMap.size()];
        for (Map.Entry<Integer, String> e : wordsMap.entrySet()) {
            keys[i] = e.getKey();
            i = i + 1;
        }
        // store result
        TreeMap<Integer, String> result = new TreeMap<>();

        // every iterate, the idx will be last index + level
        int level = 1;
        int wordKey = 0;
        String wordValue = "";
        for(int idx=0; idx <(keys.length + level); idx = idx + level){
            if (idx >= keys.length -1){
                wordKey = keys[keys.length -1];
                wordValue = wordsMap.get(wordKey);
                result.put( wordKey,wordValue);
                break;
            }
            wordKey = keys[idx];
            wordValue = wordsMap.get(wordKey);
            result.put( wordKey,wordValue);
            level = level + 1;
        }
        for (Map.Entry<Integer, String> e : result.entrySet()) {
            System.out.println(e.getKey()+": " + e.getValue());
        }
        for (Map.Entry<Integer, String> e : result.entrySet()) {
            System.out.print(e.getValue() + " ");
        }

    }

    private static TreeMap<Integer, String> readFile(String filePath) {
        TreeMap<Integer, String> retMap = new TreeMap<>();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(filePath));
            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                String[] aLine = currentLine.split(" ");
                retMap.put(Integer.parseInt(aLine[0]), aLine[1]);
            }
        } catch (IOException e) {
            throw new RuntimeException(e.getCause());
        } finally {
            try {
                if (reader != null) {
                    reader.close(); // Close the BufferedReader
                }
            } catch (IOException ex) {
                throw new RuntimeException(ex.getCause());
            }
        }
        return retMap;
    }
}
