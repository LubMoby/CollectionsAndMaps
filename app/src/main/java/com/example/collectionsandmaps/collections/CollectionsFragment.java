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

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class CollectionsFragment extends Fragment{
    private RecyclerView collectionRecycler;
    private Unbinder unbinder;
    @BindView(R.id.progress_bar) ProgressBar progressBar;
    private ArrayList<CollectionsTestResult> testResults;

    CollectionsAdapter adapterCollections;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_collection,container,false);
        unbinder = ButterKnife.bind(this, rootView);
        testResults = new ArrayList<>();
        adapterCollections = new CollectionsAdapter(testResults);
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
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    private class CalculateResultTest extends AsyncTask<ArrayList<CollectionsTestResult>,Void,ArrayList<CollectionsTestResult>>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressBar.setVisibility(View.VISIBLE);
            collectionRecycler.setVisibility(View.INVISIBLE);
            testResults.clear();
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
         }

        @Override
        protected ArrayList<CollectionsTestResult> doInBackground(ArrayList<CollectionsTestResult>... arrayLists) {
            try {
                return new CalculateCollections(10,100, testResults).getListResultCollections();
            }catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override
        protected void onPostExecute(ArrayList<CollectionsTestResult> resultList){
            super.onPostExecute(resultList);
            progressBar.setVisibility(View.GONE);
            collectionRecycler.setVisibility(View.VISIBLE);
            adapterCollections.setItems(resultList);
        }
    }
}

