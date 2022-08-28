package com.spring.Controllers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.jpa.EntityManagerFactoryInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Controller
@RequestMapping(value = "/db/execute")
public class DbQueryExecuteController {
    //@Autowired
    //DataSource dataSource;
    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    EntityManagerFactoryInfo entityManagerFactoryInfo;

    @GetMapping
    public String getExecutePage() {
        return "executePage";
    }
    private final Logger logger = LoggerFactory.getLogger(DbQueryExecuteController.class);

    @PostMapping(consumes = "text/plain", produces = "application/json")
    @ResponseBody
    @SneakyThrows
    public byte[] executeQuery(@RequestBody String query) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(
                Objects.requireNonNull(entityManagerFactoryInfo.getDataSource()));
        List<Map<String, Object>> resultList = jdbcTemplate.queryForList(query);

        if (resultList.size() == 0)
            return new byte[] {};

        ObjectWriter objectWriter =
                objectMapper.writerFor(new TypeReference<List<Map<String, Object>>>() {});

        logger.info(objectWriter.writeValueAsString(resultList));

        return objectWriter.writeValueAsBytes(resultList);
    }
}
