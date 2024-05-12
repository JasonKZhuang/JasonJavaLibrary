package com.jasonz.advancedFeatures.concurrency.pausingExecution;

class Consumer implements Runnable {
    private final Message message;

    public Consumer(Message message) {
        this.message = message;
    }

    @Override
    public void run() {
        String msg;
        do {
            msg = message.take();
            System.out.println("Consumed immediately: " + msg);
            try {
                // Simulate time taken to process the message
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        } while (!msg.equals("DONE"));
    }
}
