package com.jasonz.advancedFeatures.concurrency;

public class SleepMessages {
    public static void main(String[] args) throws InterruptedException {
        String[] importantInfo = {
                "Mares eat oats",
                "Does eat oats",
                "Little lambs eat ivy",
                "Lesson6Distinct kid will eat ivy too"
        };

        for (String s : importantInfo) {
            //Pause for 4 seconds
            Thread.sleep(4000);
            //Print a message
            System.out.println(s);
        }
    }
}