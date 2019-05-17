package com.example.collectionsandmaps.di.main.maps;

import com.example.collectionsandmaps.main.maps.CalculateMaps;
import com.example.collectionsandmaps.main.maps.MapsAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class MapsModule {

    @Provides
    static MapsAdapter provideMapsAdapter(){
        return new MapsAdapter();
    }

    @Provides
    static TreeMap<Integer,Integer> provideTreeMap(){return new TreeMap<>();}

    @Provides
    static HashMap<Integer,Integer> provideHashMap(){return new HashMap<>();}

    @Provides
    static CalculateMaps provideCalculateMaps(TreeMap<Integer, Integer> treeMap, HashMap<Integer, Integer> hashMap) {
        return new CalculateMaps(treeMap, hashMap);
    }

}
