package com.example.collectionsandmaps;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MapsFragment extends Fragment {
    private Unbinder unbinder;
    protected RecyclerView mapRecycler;
    protected Button mapsButton;
    @BindView(R.id.maps_recycler)
    RecyclerView maps_recycler;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_map,container,false);
        unbinder = ButterKnife.bind(this, rootView);
        mapRecycler = rootView.findViewById(R.id.maps_recycler);

        ArrayList<CollectionsTestResult> arrayList = new ArrayList<>();
//        for (int i = 10; i < 100 ; i++) {
//            arrayList.add(" Значение " + Integer.toString(i));
//        }

        CollectionsAdapter adapter = new CollectionsAdapter(arrayList);
        mapRecycler.setAdapter(adapter);
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(),2);
        mapRecycler.setLayoutManager(layoutManager);
        mapsButton = rootView.findViewById(R.id.button_maps);
        mapsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickMapsCalculate(v);
            }
        });
        return rootView;
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    public void onClickMapsCalculate(View view) {
        //
    }
}
