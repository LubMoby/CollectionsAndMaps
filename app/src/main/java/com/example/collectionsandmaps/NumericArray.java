package com.example.collectionsandmaps;

import java.util.ArrayList;

public class NumericArray {
    private static ArrayList<String> arrayList = new ArrayList<>(10);
    public static ArrayList<String>FillArray(){
        for (int i = 0; i < arrayList.size() ; i++) {
            arrayList.add(Integer.toString(i));
        }
        return arrayList;
    }
}
