package com.example.collectionsandmaps.di.main.collections;

import com.example.collectionsandmaps.main.collections.CalculateCollections;
import com.example.collectionsandmaps.main.collections.CollectionsAdapter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArrayList;

import dagger.Module;
import dagger.Provides;

@Module
public class CollectionsModule {

    @Provides
    static CollectionsAdapter provideAdapterCollections(){
        return new CollectionsAdapter();
    }

    @Provides
    static ArrayList<Integer> provideArrayList(){
        return new ArrayList<>();
    }

    @Provides
    static LinkedList<Integer> provideLinkedList(){
        return new LinkedList<>();
    }

    @Provides
    static CopyOnWriteArrayList<Integer> provideCopyOnWriteArrayList(){
        return  new CopyOnWriteArrayList<>();
    }

    @Provides
    static CalculateCollections provideCalculateCollections(
            ArrayList<Integer> arrayList,
            LinkedList<Integer> linkedList,
            CopyOnWriteArrayList<Integer> copyOnWriteArrayList){
        return new CalculateCollections(arrayList,linkedList,copyOnWriteArrayList);
    }
}
