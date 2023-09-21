package ru.netology.jdbctask.repository;

import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static ru.netology.jdbctask.JdbcTaskApplication.read;

@Repository
public class MyRepository {

    private Statement statement;

    private final String sqlSelectProductName = read("myScript.sql");

    public MyRepository() throws SQLException {
        String jdbcUrl = "jdbc:postgresql://localhost:5432/postgres?user=postgres&password=postgres";

        Connection connection = DriverManager.getConnection(jdbcUrl);
        statement = connection.createStatement();
    }

    public List<String> getProductName(String name) throws SQLException {

        List<String> result = new ArrayList<>();

        ResultSet resultSet = statement.executeQuery(sqlSelectProductName.replace("%NAME%", name));
        while (resultSet.next()) {
            String productName = resultSet.getString("product_name");
            result.add(productName);
        }

        System.out.println("MyRepository - getProductName: " + result);
        return result;
    }
}
