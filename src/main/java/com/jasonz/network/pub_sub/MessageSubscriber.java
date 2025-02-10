package com.jasonz.network.pub_sub;

class MessageSubscriber implements ISubscriber {

    private String name;
    
    public MessageSubscriber(String name) {
        this.name = name;
    }
    
    @Override
    public void update(String message) {
        System.out.println(name + " received: " + message);
    }
}
