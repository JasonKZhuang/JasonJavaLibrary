package com.jasonz.network.pub_sub;

public class PubSubDemo {
    public static void main(String[] args) {
        // Create a topic
        Topic topic = new Topic();
        
        // Create subscribers
        ISubscriber sub1 = new MessageSubscriber("Subscriber 1");
        ISubscriber sub2 = new MessageSubscriber("Subscriber 2");
        
        // Subscribe to the topic
        topic.subscribe(sub1);
        topic.subscribe(sub2);
        
        // Create a publisher
        Publisher publisher = new Publisher(topic);
        
        // Publish messages
        publisher.publishMessage("Hello, world!");
        publisher.publishMessage("This is a Pub-Sub example in Java.");
        
        // Unsubscribe sub1 and publish another message
        topic.unsubscribe(sub1);
        publisher.publishMessage("Subscriber 1 will not receive this message.");
    }
}
