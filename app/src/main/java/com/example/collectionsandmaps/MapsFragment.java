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

public class MapsFragment extends Fragment {
    private RecyclerView mapsRecycler;
    private MapsAdapter mapsAdapter;
    private Unbinder unbinder;
    @BindView(R.id.progress_bar_maps)
    ProgressBar progressBarMaps;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_map,container,false);
        unbinder = ButterKnife.bind(this, rootView);
        mapsRecycler = rootView.findViewById(R.id.maps_recycler);

        Button collectionsButton = rootView.findViewById(R.id.button_maps);
        collectionsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new CalculateMapsResultTest().execute();
            }
        });
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    private class CalculateMapsResultTest extends AsyncTask<ArrayList<MapsTestResult>,Void,ArrayList<MapsTestResult>> {

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
        protected ArrayList<MapsTestResult> doInBackground(ArrayList<MapsTestResult>... arrayLists) {
            try {
                return new CalculateMaps(100000,1000000).getListResultMap();
            }catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override
        protected void onPostExecute(ArrayList<MapsTestResult> resultList){
            super.onPostExecute(resultList);
            progressBarMaps.setVisibility(View.GONE);
            mapsRecycler.setVisibility(View.VISIBLE);
            mapsAdapter = new MapsAdapter(resultList);
            mapsRecycler.setAdapter(mapsAdapter);
            LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
            mapsRecycler.setLayoutManager(layoutManager);
            mapsAdapter.notifyDataSetChanged();
        }
    }
}

