package com.example.SpringDataSource.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.Statement;

@Controller
public class EmbeddedDbController {
    @Autowired
    DataSource dataSource;

    @GetMapping(value = "/embedded")
    public ResponseEntity<String> getDbData() {
        StringBuilder result = new StringBuilder();
        try (Statement statement = dataSource.getConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM cats");
            while (resultSet.next())
                result
                        .append(resultSet.getInt(1))
                        .append(" ")
                        .append(resultSet.getString(2))
                        .append(" ");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new ResponseEntity<>(result.toString(), HttpStatus.OK);
    }
}
