package com.example.collectionsandmaps.maps;

import javax.inject.Inject;

public class MapsTestResult {
    String nameTest;
    long timeTreeMap;
    long timeHashMap;

    @Inject
    MapsTestResult(String nameTest, long timeTreeMap, long timeHashMap){
        this.nameTest = nameTest;
        this.timeTreeMap = timeTreeMap;
        this.timeHashMap = timeHashMap;
    }

}
