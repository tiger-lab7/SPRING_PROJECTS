package com.example.SPRING_HIBERNATE_SAVE_GET_ENTITIES.Controllers;

import com.example.SPRING_HIBERNATE_SAVE_GET_ENTITIES.Models.RepositoryOperations;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
@RequestMapping("/")
public class BasicController {
    @Autowired
    ApplicationContext applicationContext;
    @Autowired
    ObjectMapper objectMapper;

    @GetMapping(value = "/get_all/{entityRepositoryName}", produces = "text/html")
    String getResult(@PathVariable("entityRepositoryName") String entityRepositoryName, Model model) {
        RepositoryOperations repositoryOperations =
                applicationContext.getBean(entityRepositoryName, RepositoryOperations.class);
        model.addAttribute("resultList", repositoryOperations.getAll());
        return "resultPage";
    }

    @PostMapping(value = "/add_entity/{entityRepositoryName}", consumes = "application/json")
    ResponseEntity<Object> addEntity(@PathVariable("entityRepositoryName") String entityRepositoryName,
                             @RequestBody String stringEntity) throws IOException {
        RepositoryOperations repositoryOperations =
                applicationContext.getBean(entityRepositoryName, RepositoryOperations.class);
        Class entityClass = repositoryOperations.getEntityClass();
        if (objectMapper.canSerialize(entityClass)) {
            ObjectReader objectReader = objectMapper.readerFor(entityClass);
            Object entity = objectReader.readValue(stringEntity);
            repositoryOperations.addEntity(entity);

            return ResponseEntity.ok(null);
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping(value = "/delete_all/{entityRepositoryName}")
    ResponseEntity<?> deleteAll(@PathVariable("entityRepositoryName") String entityRepositoryName) {
        RepositoryOperations repositoryOperations =
                applicationContext.getBean(entityRepositoryName, RepositoryOperations.class);
        repositoryOperations.deleteAll();
        return ResponseEntity.ok(null);
    }

    @GetMapping(value = "/delete/{entityRepositoryName}/{idToDelete}")
    ResponseEntity<?> deleteOne(@PathVariable("entityRepositoryName") String entityRepositoryName,
                                @PathVariable("idToDelete") String idToDelete) {
        RepositoryOperations repositoryOperations =
                applicationContext.getBean(entityRepositoryName, RepositoryOperations.class);
        repositoryOperations.deleteOne(idToDelete);
        return ResponseEntity.ok(null);
    }
}
