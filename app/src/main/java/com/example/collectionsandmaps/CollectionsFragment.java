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
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class CollectionsFragment extends Fragment{
    protected RecyclerView collectionRecycler;
    protected Button collectionsButton;
    private Unbinder unbinder;
    @BindView(R.id.collection_recycler) RecyclerView collection_recycler;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_collection,container,false);
        unbinder = ButterKnife.bind(this, rootView);
        collectionRecycler = rootView.findViewById(R.id.collection_recycler);
        ArrayList<String> arrayList = new ArrayList<>();
        List<String> linkedList = new LinkedList<>();
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        arrayList.add("Action"); arrayList.add("ArrayList"); arrayList.add("LinkedList"); arrayList.add("Copy On Write ArrayList");
        for (int i = 1; i < 10 ; i++) {
            arrayList.add(" " + Integer.toString(i));
        }

        CollectionsAdapter adapter = new CollectionsAdapter(arrayList);
        collectionRecycler.setAdapter(adapter);
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(),4);
        collectionRecycler.setLayoutManager(layoutManager);
        Button collectionsButton = rootView.findViewById(R.id.button_collections);
        collectionsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickCalculate(v);
            }
        });
        return rootView;
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
    public void onClickCalculate(View view) {
        //
    }
}
