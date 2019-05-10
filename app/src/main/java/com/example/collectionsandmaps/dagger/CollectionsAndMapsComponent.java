package com.example.collectionsandmaps.dagger;

import com.example.collectionsandmaps.MainActivity;
import com.example.collectionsandmaps.collections.CollectionsFragment;
import com.example.collectionsandmaps.maps.MapsFragment;

import dagger.Component;

@Component(modules = {MapsFragmentModule.class,CollectionsFragmentModule.class})
public interface CollectionsAndMapsComponent {
    void inject(MainActivity mainActivity);
    void inject(MapsFragment mapsFragment);
    void inject(CollectionsFragment collectionsFragment);
}
