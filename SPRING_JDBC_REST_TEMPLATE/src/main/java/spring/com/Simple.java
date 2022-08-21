package spring.com;

import com.zaxxer.hikari.util.DriverDataSource;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.Properties;

@Component
public class Simple implements CommandLineRunner {

    @Autowired
    EM em;

    @Override
    @SneakyThrows
    public void run(String... args) {

        DataSource dataSource =
                new DriverDataSource("jdbc:postgresql://localhost:5432/postgres",
                        "org.postgresql.Driver",
                        new Properties(),
                        "postgres", "password");
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet("SELECT * FROM cats JOIN cats_characteristics ON cats.type = cats_characteristics.id");
        while (sqlRowSet.next())
            System.out.println(sqlRowSet.getInt(1) + " " +
                    sqlRowSet.getString(2) + " " +
                    sqlRowSet.getString(4));

        Thread.sleep(20000);
        em.runByTimer();
    }
}
