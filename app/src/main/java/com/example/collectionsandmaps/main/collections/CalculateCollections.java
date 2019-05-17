package com.example.collectionsandmaps.main.collections;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import static java.lang.System.currentTimeMillis;

public class CalculateCollections {
    private int sizeStart;
    private int sizeEnd;
    private ArrayList<Integer> arrayList;
    private LinkedList<Integer> linkedList;
    private CopyOnWriteArrayList<Integer> copyOnWriteArrayList;
    private ArrayList<CollectionsTestResult> listResultCollections;

    CalculateCollections(int sizeStart, int sizeEnd, ArrayList<CollectionsTestResult> listResultCollections){
        this.sizeStart = sizeStart;
        this.sizeEnd = sizeEnd;
        this.arrayList = new ArrayList<>();
        this.linkedList = new LinkedList<>();
        this.copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        this.listResultCollections = listResultCollections;

        init(arrayList);
        init(linkedList);
        init(copyOnWriteArrayList);
    }

    public ArrayList<CollectionsTestResult> getListResultCollections() {
        colculateCollections();
        return listResultCollections;
    }

    private void colculateCollections() {
        long timeForArrayList;
        long timeForLinkedList;
        long timeForCopyOnWriteArrayList;
        String nameTest = "";
        int element = 55;

        addToListTestResult("Загаловок", 0, 0, 0);

        nameTest = "Adding in the beginning";
        timeForArrayList = addFirst(arrayList, element);
        timeForLinkedList = addFirst(linkedList, element);
        timeForCopyOnWriteArrayList = addFirst(copyOnWriteArrayList, element);
        addToListTestResult(nameTest, timeForArrayList, timeForLinkedList, timeForCopyOnWriteArrayList);

        nameTest = "Adding in the middle";
        timeForArrayList = addMiddle(arrayList, element);
        timeForLinkedList = addMiddle(linkedList, element);
        timeForCopyOnWriteArrayList = addMiddle(copyOnWriteArrayList, element);
        addToListTestResult(nameTest, timeForArrayList, timeForLinkedList, timeForCopyOnWriteArrayList);

        nameTest = "Adding in the end";
        timeForArrayList = addEnd(arrayList, element);
        timeForLinkedList = addEnd(linkedList, element);
        timeForCopyOnWriteArrayList = addEnd(copyOnWriteArrayList, element);
        addToListTestResult(nameTest, timeForArrayList, timeForLinkedList, timeForCopyOnWriteArrayList);

        nameTest = "Search by value";
        int value = (int) (Math.random() * sizeEnd - sizeStart + 1) + sizeStart;
        timeForArrayList = searchByValue(arrayList, value);
        timeForLinkedList = searchByValue(linkedList, value);
        timeForCopyOnWriteArrayList = searchByValue(copyOnWriteArrayList, value);
        addToListTestResult(nameTest, timeForArrayList, timeForLinkedList, timeForCopyOnWriteArrayList);

        nameTest = "Removing in the beginning";
        timeForArrayList = removeBeginning(arrayList);
        timeForLinkedList = removeBeginning(linkedList);
        timeForCopyOnWriteArrayList = removeBeginning(copyOnWriteArrayList);
        addToListTestResult(nameTest, timeForArrayList, timeForLinkedList, timeForCopyOnWriteArrayList);

        nameTest = "Removing in the middle";
        timeForArrayList = removeMiddle(arrayList);
        timeForLinkedList = removeMiddle(linkedList);
        timeForCopyOnWriteArrayList = removeMiddle(copyOnWriteArrayList);
        addToListTestResult(nameTest, timeForArrayList, timeForLinkedList, timeForCopyOnWriteArrayList);

        nameTest = "Removing in the end";
        timeForArrayList = removeEnd(arrayList);
        timeForLinkedList = removeEnd(linkedList);
        timeForCopyOnWriteArrayList = removeEnd(copyOnWriteArrayList);
        addToListTestResult(nameTest, timeForArrayList, timeForLinkedList, timeForCopyOnWriteArrayList);

    }

    private void addToListTestResult(String nameTest,long timeForArrayList, long timeForLinkedList, long timeForCopyOnWriteArrayList ){
        CollectionsTestResult testResult = new CollectionsTestResult(nameTest, timeForArrayList, timeForLinkedList, timeForCopyOnWriteArrayList);
        listResultCollections.add(testResult);
    }

    private void init (List list){
        for (int i = 0; i < sizeEnd - sizeStart; i++) {
            list.add(sizeStart+i);
        }
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
