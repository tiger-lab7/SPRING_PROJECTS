package com.example.data;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class CatList {
    private final String catListJsonURL = "src/main/resources/cats_in_hotel.json";
    private List<Cat> catList;

    public List<Cat> getCatList() {
        if (catList == null) {
            ObjectMapper objectMapper = new ObjectMapper();
            ObjectReader objectReader = objectMapper.readerForListOf(Cat.class);
            try {
                catList = objectReader.readValue(new File(catListJsonURL));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return catList;
    }
}
