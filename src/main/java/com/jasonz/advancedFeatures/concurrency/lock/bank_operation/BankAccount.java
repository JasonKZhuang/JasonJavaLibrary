package com.jasonz.advancedFeatures.concurrency.lock.bank_operation;

import lombok.Getter;

import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {

    @Getter
    private double balance;

    // ReentrantLock is a mutual exclusion lock with the same basic behavior as the implicit monitor lock accessed using synchronized methods and statements,
    // but with extended capabilities.
    // lock: A ReentrantLock to ensure that only one thread can modify the balance at a time.
    private final ReentrantLock lock = new ReentrantLock();

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        lock.lock();
        try {
            balance += amount;
            System.out.println(Thread.currentThread().getName() + " deposited " + amount + ", balance: " + balance);
        } finally {
            lock.unlock();
        }
    }

    public void withdraw(double amount) {
        lock.lock();
        try {
            if (balance >= amount) {
                balance -= amount;
                System.out.println(Thread.currentThread().getName() + " withdrew " + amount + ", balance: " + balance);
            } else {
                System.out.println(Thread.currentThread().getName() + " insufficient funds for withdrawal, balance: " + balance);
            }
        } finally {
            lock.unlock();
        }
    }

}