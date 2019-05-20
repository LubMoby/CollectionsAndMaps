package com.example.collectionsandmaps.main.maps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

import static java.lang.System.currentTimeMillis;

public class CalculateMaps {
    private TreeMap<Integer,Integer> treeMap;
    private HashMap<Integer,Integer> hashMap;

    public CalculateMaps(TreeMap<Integer, Integer> treeMap, HashMap<Integer, Integer> hashMap) {
        this.treeMap = treeMap;
        this.hashMap = hashMap;
    }

    private void init (Map<Integer,Integer> map){
        int sizeStart = 10;
        int sizeEnd = 100;
        for (int i = 0; i < sizeEnd-sizeStart ; i++) {
            map.put(i, sizeStart+i);
        }
    }

    private long addNew(Map<Integer,Integer> map){
        long startTime;
        long stopTime;
        startTime = currentTimeMillis();
        map.put(map.size(),55);
        stopTime = currentTimeMillis();
        return stopTime - startTime;
    }

    private long searchByKey(Map<Integer,Integer> map, Integer key){
        long startTime;
        long stopTime;
        startTime = currentTimeMillis();
        map.get(key);
        stopTime = currentTimeMillis();
        return stopTime - startTime;
    }

    private long removingByKey(Map<Integer,Integer> map, Integer key){
        long startTime;
        long stopTime;
        startTime = currentTimeMillis();
        map.remove(key);
        stopTime = currentTimeMillis();
        return stopTime - startTime;
    }

    public ArrayList<MapsResult> calculateMapsReault(){
        long timeForTreeMap;
        long timeForHashMap;
        Integer keySearch = (int)treeMap.size()/2;
        Integer keyRemoving = (int)treeMap.size()/3;
        ArrayList<MapsResult> listMapsResult = new ArrayList<>();

        init(treeMap);
        init(hashMap);

        timeForTreeMap = addNew(treeMap);
        timeForHashMap = addNew(hashMap);
        addToListTestResult(listMapsResult,"Adding new", timeForTreeMap, timeForHashMap);

        timeForTreeMap = searchByKey(treeMap,keySearch);
        timeForHashMap = searchByKey(hashMap,keySearch);
        addToListTestResult(listMapsResult,"Search by key", timeForTreeMap, timeForHashMap);

        timeForTreeMap = removingByKey(treeMap,keyRemoving);
        timeForHashMap = removingByKey(hashMap,keyRemoving);
        addToListTestResult(listMapsResult,"Removing", timeForTreeMap, timeForHashMap);

        return listMapsResult;
    }

    private void addToListTestResult(ArrayList<MapsResult> list, String nameTest, long timeTreeMap, long timeHashMap){
        MapsResult testResultMap = new MapsResult(nameTest, timeTreeMap, timeHashMap);
        list.add(testResultMap);
    }
}
