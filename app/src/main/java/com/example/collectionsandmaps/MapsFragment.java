package com.example.collectionsandmaps;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

public class MapsFragment extends ListFragment{

    public MapsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ArrayAdapter<String> adapterMaps = new ArrayAdapter<>(
                inflater.getContext(),
                android.R.layout.simple_list_item_1,
                NumericArray.FillArray()
        );
        setListAdapter(adapterMaps);
        // Inflate the layout for this fragment
        return super.onCreateView(inflater, container, savedInstanceState);
    }

}
