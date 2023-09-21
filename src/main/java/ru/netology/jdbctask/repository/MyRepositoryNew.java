package ru.netology.jdbctask.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static ru.netology.jdbctask.JdbcTaskApplication.read;

@Repository
@EnableAutoConfiguration
public class MyRepositoryNew {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private final String sqlSelectProductName = read("myScriptNew.sql");

    public MyRepositoryNew(DataSource dataSource, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.dataSource = dataSource;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public List<String> getProductName(String name) throws SQLException {

        List<String> result = new ArrayList<>();

        List<Map<String, Object>> sqlResult = namedParameterJdbcTemplate.queryForList(sqlSelectProductName, new MapSqlParameterSource("name", name));
        for (Map<String, Object> map : sqlResult) {
            if (map.containsKey("product_name")) {
                result.add(map.get("product_name").toString());
            }
        }

        System.out.println("MyRepositoryNew - getProductName: " + result);
        return result;
    }
}
