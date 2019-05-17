package com.example.collectionsandmaps.dagger;

import com.example.collectionsandmaps.MainActivity;

import dagger.Component;

@Component(modules = MapsFragmentModule.class)
public interface MapsComponent {

    void inject(MainActivity mainActivity);
}
