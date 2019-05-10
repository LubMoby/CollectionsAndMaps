package com.example.collectionsandmaps.collections;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import com.example.collectionsandmaps.R;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.inject.Inject;
import javax.inject.Named;

public class CollectionsFragment extends Fragment{

    @Inject
    @Named("testResultCollections")
    ArrayList<LinkedHashMap<String, Long[]>> testResultCollections;

    @Inject ArrayList<Integer> arrayList;
    @Inject LinkedList<Integer> linkedList;
    @Inject CopyOnWriteArrayList<Integer> copyOnWriteArrayList;
    @Inject CollectionsAdapter adapterCollections;
    @Inject CalculateCollections calculateCollections;

    private RecyclerView collectionRecycler;
    private ProgressBar progressBar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_collection,container,false);
        collectionRecycler = rootView.findViewById(R.id.collection_recycler);
        collectionRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        collectionRecycler.setAdapter(adapterCollections);
        Button collectionsButton = rootView.findViewById(R.id.button_collections);
        collectionsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new CalculateResultTest().execute();
            }
        });
        progressBar = rootView.findViewById(R.id.progress_bar);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    private class CalculateResultTest extends AsyncTask<ArrayList<LinkedHashMap<String, Long[]>>, Void, ArrayList<LinkedHashMap<String, Long[]>>>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressBar.setVisibility(View.VISIBLE);
            collectionRecycler.setVisibility(View.INVISIBLE);
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
         }

        @Override
        protected ArrayList<LinkedHashMap<String, Long[]>> doInBackground(ArrayList<LinkedHashMap<String, Long[]>>... arrayLists) {
            try {
                return calculateCollections.calculateCollectionsResult();
            }catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override
        protected void onPostExecute(ArrayList<LinkedHashMap<String, Long[]>> resultList){
            super.onPostExecute(resultList);
            progressBar.setVisibility(View.GONE);
            collectionRecycler.setVisibility(View.VISIBLE);
            adapterCollections.setItems(resultList);
        }
    }
}

