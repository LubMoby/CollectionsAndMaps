package com.example.collectionsandmaps.dagger;

import android.content.Context;

import dagger.Module;

@Module
public class MapsFragmentModule {
    private final Context context;

    public MapsFragmentModule(Context context) {
        this.context = context;

    }

//    @Provides
//    public RecyclerView.LayoutManager provideLayoutManager(){
//        return new LinearLayoutManager(context);
//    }
}
