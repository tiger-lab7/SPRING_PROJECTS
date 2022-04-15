package com.example.spring_simple_server;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class SimpleJDBC_DAO implements SimpleDAO {
    private Connection connection = null;

    @PostConstruct
    private void createConnection() {
        try {

            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(
                        Properties.dbPath, Properties.dbUser, Properties.dbPassword);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public List<String> readAllRecords() {
        try {
            createConnection();
            Statement statement = connection.createStatement();
            String query = "SELECT name FROM cats";
            ResultSet resultSet = statement.executeQuery(query);

            List<String> resultList = new ArrayList<>();

            while (resultSet.next())
                resultList.add(resultSet.getString(1));
            System.out.println(resultList.toString());
            return resultList;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @PreDestroy
    private void connectionFinalizer() {
        try {

            if (connection != null && !connection.isClosed())
                connection.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
