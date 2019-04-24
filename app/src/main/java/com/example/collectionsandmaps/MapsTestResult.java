package com.example.collectionsandmaps;

public class MapsTestResult {
    String nameTest;
    long timeTreeMap;
    long timeHashMap;

    MapsTestResult(String nameTest, long timeTreeMap, long timeHashMap){
        this.nameTest = nameTest;
        this.timeTreeMap = timeTreeMap;
        this.timeHashMap = timeHashMap;
    }

}
