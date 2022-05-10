package com.jasonz.database.repository;

import com.jasonz.database.DBConnectionHandler;
import com.jasonz.database.enity.UserRequest;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : Jason Zhuang
 * @date : 25/4/2022
 * @description :
 */
public class UserRequestRepository {

    Connection connection = null;

    public List<UserRequest> getRecords() {
        List<UserRequest> retObjects = new ArrayList<>();

        String sql = "SELECT " +
                "ur.id AS id, " +
                "ur.userId AS userId, " +
                "ur.productId AS productId, " +
                "ur.content AS content, " +
                "ur.createOn AS createOn, " +
                "ur.updateOn AS updateOn " +
                "FROM UserRequest AS ur ";

        Statement statement = null;
        try {
            //1. get connection;
            connection = DBConnectionHandler.getConnection();
            //2. create a statement
            statement = connection.createStatement();
            //3. execute a query
            boolean flag = statement.execute(sql);
            if (flag == true) {
                ResultSet resultSet = statement.getResultSet();
                //4. iterate the result
                // ResultSet resultSet = statement.executeQuery(sql);
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    int userId = resultSet.getInt("userId");
                    int productId = resultSet.getInt("productId");
                    InputStream content = resultSet.getBinaryStream("content");
                    Date createOn = resultSet.getDate("createOn");
                    Date updateOn = resultSet.getDate("updateOn");

                    UserRequest obj = new UserRequest();
                    obj.setId(id);
                    obj.setUserId(userId);
                    obj.setProductId(productId);
                    obj.setContent(content);
                    obj.setCreateOn(createOn);
                    obj.setUpdateOn(updateOn);
                    retObjects.add(obj);
                }
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } catch (Exception exp) {
            exp.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                // if (connection != null) {
                //     connection.close();
                // }
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            } catch (Exception exp) {
                exp.printStackTrace();
            }
        }
        return retObjects;
    }

    public UserRequest getRecord(int argId) {

        UserRequest retObject = null;

        String sql = "SELECT " +
                "ur.id AS id, " +
                "ur.userId AS userId, " +
                "ur.productId AS productId, " +
                "ur.content AS content, " +
                "ur.createOn AS createOn, " +
                "ur.updateOn AS updateOn " +
                "FROM UserRequest AS ur " +
                "WHERE ur.id = ?";

        PreparedStatement preparedStatement = null;
        try {
            //1. get connection;
            connection = DBConnectionHandler.getConnection();
            //2. create a statement
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, argId);
            //3. execute a query
            ResultSet resultSet = preparedStatement.executeQuery();
            //4. get the result
            while (resultSet.next()) {
                int userId = resultSet.getInt("userId");
                int productId = resultSet.getInt("productId");
                InputStream content = resultSet.getBinaryStream("content");
                Date createOn = resultSet.getDate("createOn");
                Date updateOn = resultSet.getDate("updateOn");
                retObject = new UserRequest();
                retObject.setId(argId);
                retObject.setUserId(userId);
                retObject.setProductId(productId);
                retObject.setContent(content);
                retObject.setCreateOn(createOn);
                retObject.setUpdateOn(updateOn);
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } catch (Exception exp) {
            exp.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            } catch (Exception exp) {
                exp.printStackTrace();
            }
        }
        return retObject;
    }

    public int saveRecords(UserRequest userRequest) {
        int updatedRows = 0;

        String sql = " INSERT INTO UserRequest " +
                "(userId, productId, content, createOn, updateOn) " +
                " VALUES " +
                "(?     ,         ?,       ?, now(),now()) " ;

        PreparedStatement pstm = null;
        try {
            //1. get connection;
            connection = DBConnectionHandler.getConnection();
            //2. prepare a statement
            pstm = connection.prepareStatement(sql);
            pstm.setInt(1, userRequest.getUserId());
            pstm.setInt(2, userRequest.getProductId());
            pstm.setBinaryStream(3, userRequest.getContent());
            //3. execute a query
            updatedRows = pstm.executeUpdate();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            updatedRows = 0;
        } catch (Exception exp) {
            exp.printStackTrace();
            updatedRows = 0;
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
                // if (connection != null) {
                //     connection.close();
                // }
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            } catch (Exception exp) {
                exp.printStackTrace();
            }
        }

        return updatedRows;
    }
}
