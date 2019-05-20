package com.example.collectionsandmaps.main.maps;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import com.example.collectionsandmaps.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;

public class MapsFragment extends DaggerFragment {

    @Inject
    CalculateMaps calculateMaps;
    @Inject
    MapsAdapter mapsAdapter;

    private RecyclerView mapsRecycler;
    private ProgressBar progressBarMaps;

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_map,container,false);
        mapsRecycler = rootView.findViewById(R.id.maps_recycler);
        mapsRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        mapsRecycler.setAdapter(mapsAdapter);
        Button collectionsButton = rootView.findViewById(R.id.button_maps);
        collectionsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new CalculateMapsResultTest().execute();
            }
        });
        progressBarMaps = rootView.findViewById(R.id.progress_bar_maps);

        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    private class CalculateMapsResultTest extends AsyncTask<ArrayList<MapsResult>,Void,ArrayList<MapsResult>> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressBarMaps.setVisibility(View.VISIBLE);
            mapsRecycler.setVisibility(View.INVISIBLE);
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected ArrayList<MapsResult> doInBackground(ArrayList<MapsResult>... arrayLists) {
            try {
                return calculateMaps.calculateMapsReault();
            }catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override
        protected void onPostExecute(ArrayList<MapsResult> resultList){
            super.onPostExecute(resultList);
            progressBarMaps.setVisibility(View.GONE);
            mapsRecycler.setVisibility(View.VISIBLE);
            mapsAdapter.setItems(resultList);
        }
    }
}

