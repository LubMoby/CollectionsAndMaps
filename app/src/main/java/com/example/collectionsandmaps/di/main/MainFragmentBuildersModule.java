package com.example.collectionsandmaps.di.main;

import com.example.collectionsandmaps.di.main.collections.CollectionsModule;
import com.example.collectionsandmaps.di.main.maps.MapsModule;
import com.example.collectionsandmaps.main.collections.CollectionsFragment;
import com.example.collectionsandmaps.main.maps.MapsFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class MainFragmentBuildersModule {

    @ContributesAndroidInjector(modules = CollectionsModule.class)
    abstract CollectionsFragment contributeCollectionsFragment();

    @ContributesAndroidInjector(modules = MapsModule.class)
    abstract MapsFragment contributeMapsFragment();
}
