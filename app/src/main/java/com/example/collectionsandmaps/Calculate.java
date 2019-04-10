package com.example.collectionsandmaps;

import java.util.ArrayList;

public class Calculate {

    public static ArrayList<String> arrayList;

    public static ArrayList<String>FillArray(){
        arrayList = new ArrayList<>();
        for (int i = 1000000; i < 10000000 ; i++) {
            arrayList.add(Integer.toString(i));
        }
        return arrayList;
    }
}
