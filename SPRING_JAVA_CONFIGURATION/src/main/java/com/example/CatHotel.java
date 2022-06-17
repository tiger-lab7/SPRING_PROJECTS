package com.example;

import com.example.data.CatList;

public class CatHotel {
    private final CatList catList;
    CatHotel(CatList catList) {
        this.catList = catList;
    }

    public void printAllCats() {
        catList.getCatList().forEach(System.out::println);
    }
}
