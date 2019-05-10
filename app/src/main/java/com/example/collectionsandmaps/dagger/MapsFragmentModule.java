package com.example.collectionsandmaps.dagger;

import android.content.Context;

import com.example.collectionsandmaps.maps.CalculateMaps;
import com.example.collectionsandmaps.maps.MapsAdapter;
import com.example.collectionsandmaps.maps.MapsFragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class MapsFragmentModule {
    private final Context context;

    public MapsFragmentModule(Context context) {
        this.context = context;
    }

    @Provides
    static TreeMap<Integer,Integer> provideTreeMap(){
        return new TreeMap<>();
    }

    @Provides
    static HashMap<Integer,Integer> provideHashMap(){
        return new HashMap<>();
    }

    @Provides
    @Named("testResultMaps")
    static ArrayList<LinkedHashMap<String, Long[]>> provideTestResults(){
        return new ArrayList<>();
    }

    @Provides
    static MapsAdapter provideMapsAdapter(@Named("testResultMaps") ArrayList<LinkedHashMap<String, Long[]>> testResults){
        return new MapsAdapter(testResults);
    }

    @Provides
    static CalculateMaps provideCalculateMaps(TreeMap<Integer,Integer> treeMap, HashMap<Integer,Integer> hashMap){
        return new CalculateMaps(treeMap, hashMap);
    }

    @Provides
    static MapsFragment provideMapsFragment(){
        MapsFragment mapsFragment = new MapsFragment();
        return mapsFragment;
    }

}
