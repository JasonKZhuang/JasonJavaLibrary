package com.jasonz.database;

import com.jasonz.database.multithread.BulkOperation;
import com.jasonz.database.repository.ProductRepository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author : Jason Zhuang
 * @date : 23/4/2022
 * @description :
 */
public class MainTestJDBC {

    public static void main(String[] args) {
        for(int i=0;i<150;i++){
            Thread thread = new Thread(new BulkOperation(i));
            thread.start();
        }
        DBConnectionHandler.closeConnection();
    }
}
