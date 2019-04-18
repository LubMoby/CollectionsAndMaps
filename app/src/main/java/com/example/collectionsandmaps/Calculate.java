package com.example.collectionsandmaps;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import static java.lang.System.currentTimeMillis;

public class Calculate {

    public static List<CollectionsTestResult> resultTest(){
        List<CollectionsTestResult> listResult = new ArrayList<>();
        CalculateIt(listResult);
        return listResult;
    }

    private static void CalculateIt(List<CollectionsTestResult> list) {
        final int sizeStart = 10;
        final int sizeEnd = 1000;
        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();
        CopyOnWriteArrayList<Integer> copyOnWriteArrayList = new CopyOnWriteArrayList<>();

        init(arrayList, sizeStart, sizeEnd);
        init(linkedList, sizeStart, sizeEnd);
        init(copyOnWriteArrayList, sizeStart, sizeEnd);

        //List<CollectionsTestResult> list = new ArrayList<>();
        long timeForArrayList;
        long timeForLinkedList;
        long timeForCopyOnWriteArrayList;
        String nameTest;

        addToListTestResult(list, "", 0, 0, 0);

        nameTest = "Adding in the beginning";
        timeForArrayList = addFirst(arrayList, 55);
        timeForLinkedList = addFirst(linkedList, 55);
        timeForCopyOnWriteArrayList = addFirst(copyOnWriteArrayList, 55);
        addToListTestResult(list, nameTest, timeForArrayList, timeForLinkedList, timeForCopyOnWriteArrayList);

        nameTest = "Adding in the middle";
        timeForArrayList = addMiddle(arrayList, 55);
        timeForLinkedList = addMiddle(linkedList, 55);
        timeForCopyOnWriteArrayList = addMiddle(copyOnWriteArrayList, 55);
        addToListTestResult(list, nameTest, timeForArrayList, timeForLinkedList, timeForCopyOnWriteArrayList);

        nameTest = "Adding in the end";
        timeForArrayList = addEnd(arrayList, 55);
        timeForLinkedList = addEnd(linkedList, 55);
        timeForCopyOnWriteArrayList = addEnd(copyOnWriteArrayList, 55);
        addToListTestResult(list, nameTest, timeForArrayList, timeForLinkedList, timeForCopyOnWriteArrayList);

        nameTest = "Search by value";
        int value = (int) (Math.random() * sizeEnd - sizeStart + 1) + sizeStart;
        timeForArrayList = searchByValue(arrayList, value);
        timeForLinkedList = searchByValue(linkedList, value);
        timeForCopyOnWriteArrayList = searchByValue(copyOnWriteArrayList, value);
        addToListTestResult(list, nameTest, timeForArrayList, timeForLinkedList, timeForCopyOnWriteArrayList);

        nameTest = "Removing in the beginning";
        timeForArrayList = removeBeginning(arrayList);
        timeForLinkedList = removeBeginning(linkedList);
        timeForCopyOnWriteArrayList = removeBeginning(copyOnWriteArrayList);
        addToListTestResult(list, nameTest, timeForArrayList, timeForLinkedList, timeForCopyOnWriteArrayList);

        nameTest = "Removing in the middle";
        timeForArrayList = removeMiddle(arrayList);
        timeForLinkedList = removeMiddle(linkedList);
        timeForCopyOnWriteArrayList = removeMiddle(copyOnWriteArrayList);
        addToListTestResult(list, nameTest, timeForArrayList, timeForLinkedList, timeForCopyOnWriteArrayList);

        nameTest = "Removing in the end";
        timeForArrayList = removeEnd(arrayList);
        timeForLinkedList = removeEnd(linkedList);
        timeForCopyOnWriteArrayList = removeEnd(copyOnWriteArrayList);
        addToListTestResult(list, nameTest, timeForArrayList, timeForLinkedList, timeForCopyOnWriteArrayList);

    }

    private static void addToListTestResult(List<CollectionsTestResult> list, String nameTest, long timeForArrayList, long timeForLinkedList, long timeForCopyOnWriteArrayList ){
        CollectionsTestResult testResult = new CollectionsTestResult(nameTest, timeForArrayList, timeForLinkedList, timeForCopyOnWriteArrayList);
        list.add(testResult);
    }

    private static void init(List list, int sizeStart, int sizeEnd) {
        for (int i = 0; i < sizeEnd-sizeStart ; i++) {
            list.add(sizeStart++);
        }
    }

    private static long addFirst(List list, int elementInt){
        long startTime;
        long stopTime;
        if (list instanceof LinkedList) {
            LinkedList linkedList = (LinkedList) list;
            startTime = currentTimeMillis();
            linkedList.addFirst(elementInt);
            stopTime = currentTimeMillis();
            return stopTime - startTime;
        }else{
            startTime = currentTimeMillis();
            list.add(0, elementInt);
            stopTime = currentTimeMillis();
            return stopTime - startTime;
        }
    }

    private static long addMiddle(List list, int elementInt){
        long startTime;
        long stopTime;
        startTime = currentTimeMillis();
        list.add((int)(list.size() / 2), elementInt);
        stopTime = currentTimeMillis();
        return stopTime - startTime;
    }

    private static long addEnd(List list, int elementInt){
        long startTime;
        long stopTime;
        startTime = currentTimeMillis();
        list.add(elementInt);
        stopTime = currentTimeMillis();
        return stopTime - startTime;
    }

    private static long searchByValue(List list, int value){
        long startTime;
        long stopTime;
        startTime = currentTimeMillis();
        list.indexOf(value);
        stopTime = currentTimeMillis();
        return stopTime - startTime;
    }

    private static long removeBeginning(List list){
        long startTime;
        long stopTime;
        startTime = currentTimeMillis();
        list.remove(0);
        stopTime = currentTimeMillis();
        return stopTime - startTime;
    }

    private static long removeMiddle(List list){
        long startTime;
        long stopTime;
        startTime = currentTimeMillis();
        list.remove((int)list.size()/2);
        stopTime = currentTimeMillis();
        return stopTime - startTime;
    }

    private static long removeEnd(List list){
        long startTime;
        long stopTime;
        startTime = currentTimeMillis();
        list.remove(list.size()-1);
        stopTime = currentTimeMillis();
        return stopTime - startTime;
    }
}
