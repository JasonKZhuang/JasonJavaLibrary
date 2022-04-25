package com.jasonz.database.multithread;

import com.jasonz.database.repository.ProductRepository;

/**
 * @author : Jason Zhuang
 * @date : 23/4/2022
 * @description :
 */
public class BulkOperationRunnable implements  Runnable{
    private int threadId =0;

    public BulkOperationRunnable(int id){
        this.threadId = id;
    }

    @Override
    synchronized public void run() {
        try {
            Thread.sleep(3000);
            System.out.println(String.format("This is thread [%d] to read products.", threadId));
            ProductRepository p = new ProductRepository();
            p.getRecords();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
