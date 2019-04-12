package com.example.collectionsandmaps;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Calculate {
    public static ArrayList<String> arrayList = new ArrayList<>();
    public static List<String> linkedList = new LinkedList<>();
    public static CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();

    private static final int START = 100; //1000000;
    private static final int END = 1000;
    public static int[] arrayNum = new int[END-START];

    public static void initArrayNum(){
        for (int i = 0; i < END-START; i++) {
            arrayNum[i] = START + 1;
        }
    }

    //Adding in the beginning;
    public static void addBegin(int type){

    }
    //Adding in the middle;

    //Adding in the end;

    //Search by value;

    //Removing in the beginning;

    //Removing in the middle;

    //Removing in the end.

    public static ArrayList<String>FillArray(){
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Action"); arrayList.add("ArrayList"); arrayList.add("LinkedList"); arrayList.add("CopyOnWriteArrayList");
        for (int i = 10; i < 100 ; i++) {
            arrayList.add(" Значение " + Integer.toString(i));
        }
        return arrayList;
    }
}
