package com.example.collectionsandmaps.main.collections;

public class CollectionsResult {
    String nameTest;
    long timeForArrayList;
    long timeForLinkedList;
    long timeForCopyOnWriteArrayList;

    CollectionsResult(String nameTest, long timeForArrayList, long timeForLinkedList, long timeForCopyOnWriteArrayList){
        this.nameTest = nameTest;
        this.timeForArrayList = timeForArrayList;
        this.timeForLinkedList = timeForLinkedList;
        this.timeForCopyOnWriteArrayList = timeForCopyOnWriteArrayList;
    }

}
