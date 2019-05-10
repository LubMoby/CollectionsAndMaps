package com.example.collectionsandmaps.dagger;

import android.content.Context;

import com.example.collectionsandmaps.collections.CalculateCollections;
import com.example.collectionsandmaps.collections.CollectionsAdapter;
import com.example.collectionsandmaps.collections.CollectionsFragment;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class CollectionsFragmentModule {
    private final Context context;

    public CollectionsFragmentModule(Context context) {
        this.context = context;
    }

    @Provides
    @Named("testResultCollections")
    static ArrayList<LinkedHashMap<String, Long[]>> provideTestResultCollections(){
        return new ArrayList<>();
    }

    @Provides
    static ArrayList<Integer> provideArrayList(){
        return new ArrayList<Integer>();
    }

    @Provides
    static LinkedList<Integer> provideLinkedList(){
        return new LinkedList<Integer>();
    }

    @Provides
    static CopyOnWriteArrayList<Integer> provideCopyOnWriteArrayList(){
        return new CopyOnWriteArrayList<Integer>();
    }

    @Provides
    static CollectionsAdapter provideCollectionsAdapter(@Named("testResultCollections") ArrayList<LinkedHashMap<String, Long[]>> testResultCollections){
        return new CollectionsAdapter(testResultCollections);
    }

    @Provides
    static CalculateCollections provideCalculateCollections(ArrayList<Integer> arrayList, LinkedList<Integer> linkedList, CopyOnWriteArrayList<Integer> copyOnWriteArrayList){
        return new CalculateCollections(arrayList, linkedList, copyOnWriteArrayList);
    }

    @Provides
    static CollectionsFragment provideCollectionsFragment(){
        CollectionsFragment collectionsFragment = new CollectionsFragment();
        return collectionsFragment;
    }
}
