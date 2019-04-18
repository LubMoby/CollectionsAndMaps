package com.example.collectionsandmaps;

public class CollectionsTestResult {
    String nameTest;
    long timeForArrayList;
    long timeForLinkedList;
    long timeForCopyOnWriteArrayList;

    CollectionsTestResult(String nameTest, long timeForArrayList, long timeForLinkedList, long timeForCopyOnWriteArrayList){
        this.nameTest = nameTest;
        this.timeForArrayList = timeForArrayList;
        this.timeForLinkedList = timeForLinkedList;
        this.timeForCopyOnWriteArrayList = timeForCopyOnWriteArrayList;
    }
}
