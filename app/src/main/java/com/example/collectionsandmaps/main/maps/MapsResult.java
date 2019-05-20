package com.example.collectionsandmaps.main.maps;

public class MapsResult {
    String nameTest;
    long timeTreeMap;
    long timeHashMap;

    MapsResult(String nameTest, long timeTreeMap, long timeHashMap){
        this.nameTest = nameTest;
        this.timeTreeMap = timeTreeMap;
        this.timeHashMap = timeHashMap;
    }
}
