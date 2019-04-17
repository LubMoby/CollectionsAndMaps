package com.example.collectionsandmaps;

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

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class CollectionsFragment extends Fragment{
    protected RecyclerView collectionRecycler;
    protected Button collectionsButton;
    private Unbinder unbinder;
    //@BindView(R.id.collection_recycler) RecyclerView collection_recycler;
    private ArrayList<CollectionsTestResult> resultList;
    private CollectionsAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_collection,container,false);
        unbinder = ButterKnife.bind(this, rootView);
        collectionRecycler = rootView.findViewById(R.id.collection_recycler);

        resultList = new ArrayList<>();
//        resultList.add(new CollectionsTestResult("test1",100,100,100));
//        resultList.add(new CollectionsTestResult("test2",100,100,100));
//        resultList.add(new CollectionsTestResult("test3",100,100,100));
//        resultList.add(new CollectionsTestResult("test4",100,100,100));

        resultList = (ArrayList<CollectionsTestResult>)Calculate.resultTest();

        adapter = new CollectionsAdapter(resultList);
        collectionRecycler.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        collectionRecycler.setLayoutManager(layoutManager);
        Button collectionsButton = rootView.findViewById(R.id.button_collections);
        collectionsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new  CalculateResultTest().execute(resultList,resultList);
                adapter.notifyDataSetChanged();
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
            resultList.clear();
        }

            @Override
        protected ArrayList<CollectionsTestResult> doInBackground(ArrayList<CollectionsTestResult>... arrayLists) {
                resultList = (ArrayList<CollectionsTestResult>)Calculate.resultTest();
            return resultList;
        }
    }
}

