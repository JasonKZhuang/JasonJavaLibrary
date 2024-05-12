package com.jasonz.advancedFeatures.concurrency.pausingExecution;

class Producer implements Runnable {

    private Message message;

    public Producer(Message message) {
        this.message = message;
    }

    @Override
    public void run() {
        String[] messages = {"Hello", "World", "Multithreading", "in Java"};
        for (String s : messages) {
            message.put(s);
            System.out.println("Produced: [" + s + "] , and wait for 1 second.");
        }
        message.put("DONE");
    }
}
