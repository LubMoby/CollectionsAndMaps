package com.example.collectionsandmaps.collections;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import static java.lang.System.currentTimeMillis;

public class CalculateCollections {
    private ArrayList<Integer> arrayList;
    private LinkedList<Integer> linkedList;
    private CopyOnWriteArrayList<Integer> copyOnWriteArrayList;

    public CalculateCollections(ArrayList<Integer> arrayList, LinkedList<Integer> linkedList, CopyOnWriteArrayList<Integer> copyOnWriteArrayList){
        this.arrayList = arrayList;
        this.linkedList = linkedList;
        this.copyOnWriteArrayList = copyOnWriteArrayList;
    }

    private void init (List list){
        int sizeStart = 10;
        int sizeEnd = 100;
        for (int i = 0; i < sizeEnd - sizeStart; i++) {
            list.add(sizeStart+i);
        }
    }

    public ArrayList<LinkedHashMap<String, Long[]>> calculateCollectionsResult() {
        long timeForArrayList;
        long timeForLinkedList;
        long timeForCopyOnWriteArrayList;
        String nameTest = "";
        int element = 55;
        ArrayList<LinkedHashMap<String, Long[]>> listResultCollections = new ArrayList<>();

        init(arrayList);
        init(linkedList);
        init(copyOnWriteArrayList);

        nameTest = "Adding in the beginning";
        timeForArrayList = addFirst(arrayList, element);
        timeForLinkedList = addFirst(linkedList, element);
        timeForCopyOnWriteArrayList = addFirst(copyOnWriteArrayList, element);
        addToListTestResult(listResultCollections, nameTest, timeForArrayList, timeForLinkedList, timeForCopyOnWriteArrayList);

        nameTest = "Adding in the middle";
        timeForArrayList = addMiddle(arrayList, element);
        timeForLinkedList = addMiddle(linkedList, element);
        timeForCopyOnWriteArrayList = addMiddle(copyOnWriteArrayList, element);
        addToListTestResult(listResultCollections, nameTest, timeForArrayList, timeForLinkedList, timeForCopyOnWriteArrayList);

        nameTest = "Adding in the end";
        timeForArrayList = addEnd(arrayList, element);
        timeForLinkedList = addEnd(linkedList, element);
        timeForCopyOnWriteArrayList = addEnd(copyOnWriteArrayList, element);
        addToListTestResult(listResultCollections, nameTest, timeForArrayList, timeForLinkedList, timeForCopyOnWriteArrayList);

        nameTest = "Search by value";
        int value = (int) (Math.random() * arrayList.size() - arrayList.get(arrayList.size()-1) + 1) + arrayList.get(arrayList.size()-1);
        timeForArrayList = searchByValue(arrayList, value);
        timeForLinkedList = searchByValue(linkedList, value);
        timeForCopyOnWriteArrayList = searchByValue(copyOnWriteArrayList, value);
        addToListTestResult(listResultCollections, nameTest, timeForArrayList, timeForLinkedList, timeForCopyOnWriteArrayList);

        nameTest = "Removing in the beginning";
        timeForArrayList = removeBeginning(arrayList);
        timeForLinkedList = removeBeginning(linkedList);
        timeForCopyOnWriteArrayList = removeBeginning(copyOnWriteArrayList);
        addToListTestResult(listResultCollections, nameTest, timeForArrayList, timeForLinkedList, timeForCopyOnWriteArrayList);

        nameTest = "Removing in the middle";
        timeForArrayList = removeMiddle(arrayList);
        timeForLinkedList = removeMiddle(linkedList);
        timeForCopyOnWriteArrayList = removeMiddle(copyOnWriteArrayList);
        addToListTestResult(listResultCollections, nameTest, timeForArrayList, timeForLinkedList, timeForCopyOnWriteArrayList);

        nameTest = "Removing in the end";
        timeForArrayList = removeEnd(arrayList);
        timeForLinkedList = removeEnd(linkedList);
        timeForCopyOnWriteArrayList = removeEnd(copyOnWriteArrayList);
        addToListTestResult(listResultCollections, nameTest, timeForArrayList, timeForLinkedList, timeForCopyOnWriteArrayList);

        return listResultCollections;

    }

    private void addToListTestResult(ArrayList<LinkedHashMap<String, Long[]>> listResultCollections, String nameTest,long timeForArrayList, long timeForLinkedList, long timeForCopyOnWriteArrayList ){
        LinkedHashMap<String, Long[]> result = new LinkedHashMap<>();
        result.put(nameTest, new Long[]{timeForArrayList,timeForLinkedList,timeForCopyOnWriteArrayList});
        listResultCollections.add(result);
    }

    private long addFirst (List list, int elementInt){
        long startTime;
        long stopTime;
        if (list instanceof LinkedList) {
            LinkedList linkedList = (LinkedList) list;
            startTime = currentTimeMillis();
            linkedList.addFirst(elementInt);
            stopTime = currentTimeMillis();
            return stopTime - startTime;
        } else {
            startTime = currentTimeMillis();
            list.add(0, elementInt);
            stopTime = currentTimeMillis();
            return stopTime - startTime;
        }
    }

    private long addMiddle (List list,int elementInt){
        long startTime;
        long stopTime;
        startTime = currentTimeMillis();
        list.add((int) (list.size() / 2), elementInt);
        stopTime = currentTimeMillis();
        return stopTime - startTime;
    }

    private long addEnd (List list,int elementInt){
        long startTime;
        long stopTime;
        startTime = currentTimeMillis();
        list.add(elementInt);
        stopTime = currentTimeMillis();
        return stopTime - startTime;
    }

    private long searchByValue (List list,int value){
        long startTime;
        long stopTime;
        startTime = currentTimeMillis();
        list.indexOf(value);
        stopTime = currentTimeMillis();
        return stopTime - startTime;
    }

    private long removeBeginning (List list){
        long startTime;
        long stopTime;
        startTime = currentTimeMillis();
        list.remove(0);
        stopTime = currentTimeMillis();
        return stopTime - startTime;
    }

    private long removeMiddle (List list){
        long startTime;
        long stopTime;
        startTime = currentTimeMillis();
        list.remove((int) list.size() / 2);
        stopTime = currentTimeMillis();
        return stopTime - startTime;
    }

    private long removeEnd (List list){
        long startTime;
        long stopTime;
        startTime = currentTimeMillis();
        list.remove(list.size() - 1);
        stopTime = currentTimeMillis();
        return stopTime - startTime;
    }
}
