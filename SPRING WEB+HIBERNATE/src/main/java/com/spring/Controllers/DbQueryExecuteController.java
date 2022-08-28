package com.spring.Controllers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/db/execute")
public class DbQueryExecuteController {
    @Autowired
    DataSource dataSource;
    @Autowired
    ObjectMapper objectMapper;

    @GetMapping
    public String getExecutePage() {
        return "executePage";
    }

    @PostMapping(consumes = "text/plain", produces = "application/json")
    @ResponseBody
    @SneakyThrows
    public byte[] executeQuery(@RequestBody String query) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        List<Map<String, Object>> resultList = jdbcTemplate.queryForList(query);
        if (resultList.size() == 0)
            return new byte[] {};

        ObjectWriter objectWriter =
                objectMapper.writerFor(new TypeReference<List<Map<String, Object>>>() {});

        String result = objectWriter.writeValueAsString(resultList);
        System.out.println(result);

        return objectWriter.writeValueAsBytes(resultList);
    }
}
