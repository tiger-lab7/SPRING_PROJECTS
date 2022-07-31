package com.example.some_project;

import com.example.some_project.Repository.DataSourceBean;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

@SpringBootTest
class SomeProjectApplicationTests {
    private final ConfigurableApplicationContext context;
    private final DataSourceBean dataSourceBean;
    private final Logger logger = LoggerFactory.getLogger(SomeProjectApplication.class);

    SomeProjectApplicationTests(@Autowired ConfigurableApplicationContext context,
                                @Autowired DataSourceBean dataSourceBean) {
        this.context = context;
        this.dataSourceBean = dataSourceBean;
    }

    @Test
    void contextLoads() {
        Assertions.assertFalse(context == null);
    }

    @Test
    @SneakyThrows
    void testDataSource() {
        DataSource dataSource = dataSourceBean.getDataSource();

        Connection connection = dataSource.getConnection();
        connection.setAutoCommit(false);
        Statement statement = connection.createStatement();
        statement.execute("CREATE TABLE IF NOT EXISTS my_table(id SERIAL PRIMARY KEY," +
                " name VARCHAR(20) NOT NULL)");
        statement.execute("INSERT INTO my_table VALUES(1, 'IGOR')");
        connection.commit();

        ResultSet resultSet = statement.executeQuery("SELECT * FROM my_table");
        while (resultSet.next())
            logger.info(resultSet.getInt("id") + " "
                    + resultSet.getString("name"));

        statement.execute("DROP TABLE my_table");
        connection.commit();

        statement.close();
        connection.close();
    }
}
