package com.jasonz.database.multithread;

import com.jasonz.database.DBConnectionHandler;

/**
 * @author : Jason Zhuang
 * @date : 23/4/2022
 * @description :
 */
public class MainTestJDBCMultiThreads {

    public static void main(String[] args) {
        for(int i=0;i<150;i++){
            Thread thread = new Thread(new BulkOperationRunnable(i));
            thread.start();
        }
        DBConnectionHandler.closeConnection();
    }
}
