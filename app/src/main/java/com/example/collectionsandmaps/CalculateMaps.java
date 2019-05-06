package com.example.collectionsandmaps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static java.lang.System.currentTimeMillis;

public class CalculateMaps {
    private int sizeStart;
    private int sizeEnd;
    private TreeMap<Integer,Integer> treeMap;
    private HashMap<Integer,Integer> hashMap;
    private ArrayList<MapsTestResult> list;

    public CalculateMaps(int sizeStart, int sizeEnd) {
        this.sizeStart = sizeStart;
        this.sizeEnd = sizeEnd;
        treeMap = new TreeMap<Integer,Integer>();
        hashMap = new HashMap<Integer,Integer>();
        init(treeMap);
        init(hashMap);
        list = new ArrayList<>();
    }

    private void init (Map<Integer,Integer> map){
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

    private void colculateMaps(Integer keySearch,Integer keyRemoving){
        long timeForTreeMap;
        long timeForHashMap;

        timeForTreeMap = addNew(treeMap);
        timeForHashMap = addNew(hashMap);
        addToListTestResult(list,"Adding new", timeForTreeMap, timeForHashMap);

        timeForTreeMap = searchByKey(treeMap,keySearch);
        timeForHashMap = searchByKey(hashMap,keySearch);
        addToListTestResult(list,"Search by key", timeForTreeMap, timeForHashMap);

        timeForTreeMap = removingByKey(treeMap,keyRemoving);
        timeForHashMap = removingByKey(hashMap,keyRemoving);
        addToListTestResult(list,"Removing", timeForTreeMap, timeForHashMap);
    }

    private static void addToListTestResult(List<MapsTestResult> list, String nameTest, long timeTreeMap, long timeHashMap){
        MapsTestResult testResultMap = new MapsTestResult(nameTest, timeTreeMap, timeHashMap);
        list.add(testResultMap);
    }

    public ArrayList<MapsTestResult> getListResultMap(){
        Integer keySearch = (int)treeMap.size()/2;
        Integer keyRemoving = (int)treeMap.size()/3;

        colculateMaps(keySearch,keyRemoving);
        return list;
    }
}
