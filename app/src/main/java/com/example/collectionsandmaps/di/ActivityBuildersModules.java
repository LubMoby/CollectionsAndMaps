package com.example.collectionsandmaps.di;

import com.example.collectionsandmaps.MainActivity;
import com.example.collectionsandmaps.di.main.MainFragmentBuildersModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuildersModules {

    @ContributesAndroidInjector(modules = MainFragmentBuildersModule.class)
    abstract MainActivity contributeMainActivity();

}
