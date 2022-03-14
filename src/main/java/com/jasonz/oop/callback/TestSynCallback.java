/*
 * Asynchronous and Synchronous Callbacks in Java
 * A CallBack Function is a function that is passed into another function as an argument
 * and is expected to execute after some kind of event.
 *
 * The purpose of the callback function is to inform a class Sync/Async if some work in another class is done.
 * This is very useful when working with Asynchronous tasks.
 *
 * Suppose we want to perform some routine tasks
 * like perform some operation or display content after clicking a button,
 * or fetching data from internet.
 *
 * This is also used in event handling, as we get notified when a button is clicked via callback function.
 *
 * This type of design pattern is used in Observer Design Pattern.
 * The observer pattern is a software design pattern
 * in which an object, called the subject, maintains a list of its dependent, called observers,
 * and notifies them automatically of any state changes,
 * usually by calling one of their methods( Source:wiki ).
 * In Java, Callbacks can be implemented using an interface.
 *
 * The general procedure for implementation is given below:
 * 1. Define the methods in an interface that we want to invoke after callback.
 * 2. Define a class that will implement the callback methods of the interface.
 * 3. Define a reference in other class to register the callback interface.
 * 4. Use that reference to invoke the callback method.
 *
 * Synchronous Callback
 * The code execution will block or wait for the event before continuing.
 * Until your event returns a response, your program will not execute any further.
 *
 * When To Use Synchronous Callback :
 * Any process having multiple tasks where the tasks must be executed in sequence
 * ,and doesn’t occupy much time should use synchronous Callbacks.
 * For example : You’re in a movie queue for ticket you can’t get one until everyone in front of you gets one.
 *
 * References:
 * https://www.javaworld.com/article/2077462/learn-java/java-tip-10–implement-callback-routines-in-java.html
 */
package com.jasonz.oop.callback;

/**
 * @author Jason.Zhuang
 * Oct 22, 2019
 * TestCallback.java
 * Describe:
 */
public class TestSynCallback {
    private SynCallbackEventListener mListener; // listener field

    // Driver Function
    public static void main(String[] args) {
        TestSynCallback obj = new TestSynCallback();
        SynCallbackEventListener mListener = new SynCallbackEventListenerImpl();

        obj.registerMyEventListener(mListener);

        obj.doSomething();
    }

    // setting the listener
    public void registerMyEventListener(SynCallbackEventListener mListener) {
        this.mListener = mListener;
    }

    // my synchronous task
    public void doSomething() {
        // perform any operation
        System.out.println("Performing callback before synchronous Task");

        // check if listener is registered.
        if (this.mListener != null) {
            // invoke the callback method of class A
            mListener.onSomeEvent();
        }

        System.out.println("==>Finished");
    }
}
