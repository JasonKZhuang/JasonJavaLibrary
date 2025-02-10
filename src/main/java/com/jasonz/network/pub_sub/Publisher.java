package com.jasonz.network.pub_sub;

class Publisher {
    private Topic topic;
    
    public Publisher(Topic topic) {
        this.topic = topic;
    }
    
    public void publishMessage(String message) {
        System.out.println("Publishing message: " + message);
        topic.publish(message);
    }
}
