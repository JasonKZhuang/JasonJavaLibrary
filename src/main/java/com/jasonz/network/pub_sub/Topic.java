package com.jasonz.network.pub_sub;

import java.util.ArrayList;
import java.util.List;

public class Topic {

    private List<ISubscriber> subscribers = new ArrayList<>();
    
    public void subscribe(ISubscriber ISubscriber) {
        subscribers.add(ISubscriber);
    }
    
    public void unsubscribe(ISubscriber ISubscriber) {
        subscribers.remove(ISubscriber);
    }
    
    public void publish(String message) {
        for (ISubscriber subscriber : subscribers) {
            subscriber.update(message);
        }
    }
}