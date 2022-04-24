package com.jasonz.database.repository;

import com.jasonz.database.DBConnectionHandler;
import com.jasonz.database.enity.Product;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : Jason Zhuang
 * @date : 23/4/2022
 * @description :
 */
public class ProductRepository {

    public List<Product> getRecords() {
        List<Product> retProducts = new ArrayList<>();
        String sql = "SELECT\n" +
                "\tproduct.id as id, \n" +
                "\tproduct.`name` as name \n" +
                "FROM\n" +
                "\tproduct";
        Connection connection = null;
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
                    String name = resultSet.getString("name");
                    System.out.println(String.format("record: [id: %d] [name:%s]", id, name));

                    Product product = new Product();
                    product.setId(id);
                    product.setName(name);
                    retProducts.add(product);
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
        return retProducts;
    }


}
