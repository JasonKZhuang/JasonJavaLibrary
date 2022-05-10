package com.jasonz.database;

import com.jasonz.oop.io.FileResourcesUtils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author : Jason Zhuang
 * @date : 23/4/2022
 * @description :
 */
public class DBConnectionHandler {

    private static Connection conn;

    private static String datasourceDriverClassName;
    private static String datasourceUrl;
    private static String datasourceUsername;
    private static String datasourcePassword;

    public static Connection getConnection() {
        try {
            if (conn == null) {
                Properties properties = new Properties();
                InputStream in = getFileFromResourceAsStream("db.properties");
                properties.load(in);
                in.close();
                datasourceDriverClassName = properties.getProperty("datasource.driver-class-name");
                datasourceUrl = properties.getProperty("datasource.url");
                datasourceUsername = properties.getProperty("datasource.username");
                datasourcePassword = properties.getProperty("datasource.password");

                //1. 加载并注册JDBC驱动
                Class.forName(datasourceDriverClassName);
                //2. 创建数据库连接
                conn = DriverManager.getConnection(datasourceUrl, datasourceUsername, datasourcePassword);
            }
        } catch (IOException ioException) {
            conn = null;
        } catch (ClassNotFoundException e) {
            conn = null;
            e.printStackTrace();
        } catch (SQLException e) {
            conn = null;
            e.printStackTrace();
        }
        return conn;
    }

    public static void closeConnection() {
        try {
            if (conn != null && conn.isClosed() == false) {
                conn.close();
                System.out.println("The database connection has been closed.");
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } catch (Exception exp) {
            exp.printStackTrace();
        }
    }

    public static InputStream getFileFromResourceAsStream(String fileName) {
        // The class loader that loaded the class
        ClassLoader classLoader = DBConnectionHandler.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(fileName);
        // the stream holding the file content
        if (inputStream == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        } else {
            return inputStream;
        }
    }

}
