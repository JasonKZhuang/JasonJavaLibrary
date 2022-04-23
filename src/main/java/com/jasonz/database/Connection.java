package com.jasonz.database;

/**
 * @author : Jason Zhuang
 * @date : 23/4/2022
 * @description :
 */
public class Connection {
    private static Connection connection = null;

    private Connection() {
    }

    synchronized public static Connection getInstance() {
        if (connection == null) {
            connection = createConnection();
        }
        return connection;
    }

    private static Connection createConnection() {
        try{

        }
    }


}
