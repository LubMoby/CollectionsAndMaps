package com.example.collectionsandmaps.di;

import com.example.collectionsandmaps.MainActivity;
import com.example.collectionsandmaps.di.main.MainFragmentBuildersModule;
import com.example.collectionsandmaps.di.main.collections.CollectionsModule;
import com.example.collectionsandmaps.di.main.maps.MapsModule;
import com.example.collectionsandmaps.main.collections.CollectionsFragment;
import com.example.collectionsandmaps.main.maps.MapsFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuildersModules {

    @ContributesAndroidInjector(modules = MainFragmentBuildersModule.class)
    abstract MainActivity contributeMainActivity();

}
