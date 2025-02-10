package com.jasonz.advancedFeatures.concurrency.lock.bank_operation;

public class BankTransactionSimulation {

    public static void main(String[] args) {

        BankAccount account = new BankAccount(1000.0);

        Runnable depositTask = () -> {
            for (int i = 0; i < 500; i++) {
                account.deposit(100);
                try {
                    Thread.sleep(1000); // Simulate time taken for transaction
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable withdrawTask = () -> {
            for (int i = 0; i < 500; i++) {
                account.withdraw(200);
                try {
                    Thread.sleep(2000); // Simulate time taken for transaction
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread thread1 = new Thread(depositTask, "Thread-1");
        Thread thread2 = new Thread(withdrawTask, "Thread-2");

        thread1.start();
        thread2.start();

        try {
            //join() is used to wait for both threads to complete before printing the final balance.
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final balance: " + account.getBalance());
    }
}
