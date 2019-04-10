package com.example.collectionsandmaps;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MapsFragment extends Fragment {
    private Unbinder unbinder;
    @BindView(R.id.grid_map)
    GridView grid_map;
    public MapsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pager_map,container,false);
        unbinder = ButterKnife.bind(this, view);
        String[] data = {"TreeMap","HashMap","3","4","5","3","4","5","3","4","5"};

        ArrayAdapter<String> adapterMaps = new ArrayAdapter<>(
                inflater.getContext(),
                android.R.layout.simple_list_item_1,
                data
        );
        grid_map.setAdapter(adapterMaps);
        return view;
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
