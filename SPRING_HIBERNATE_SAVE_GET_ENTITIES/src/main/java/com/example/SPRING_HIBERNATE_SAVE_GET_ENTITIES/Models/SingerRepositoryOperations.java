package com.example.SPRING_HIBERNATE_SAVE_GET_ENTITIES.Models;

import com.example.SPRING_HIBERNATE_SAVE_GET_ENTITIES.Entities.Singer;
import com.example.SPRING_HIBERNATE_SAVE_GET_ENTITIES.Entities.SingerJpaRepository;
import com.example.SPRING_HIBERNATE_SAVE_GET_ENTITIES.Entities.SingerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "singers_operations")
@Lazy(false)
public class
SingerRepositoryOperations implements RepositoryOperations {
    @Autowired
    private SingerRepository singerRepository;
    @Autowired
    private SingerJpaRepository singerJpaRepository;

    public Class getEntityClass() {
        return Singer.class;
    }

    @Override
    public List<Singer> getAll() {
       return singerRepository.findAll();
    }

    @Override
    public void addEntity(Object entity) {
        singerRepository.save((Singer) entity);
    }

    @Override
    public void deleteAll() {
        singerRepository.deleteAll();
    }

    @Override
    public void deleteOne(String idToDelete) {
        singerJpaRepository.deleteOne(idToDelete);
    }
}
