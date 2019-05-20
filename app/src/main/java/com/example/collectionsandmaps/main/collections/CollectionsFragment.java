package com.example.collectionsandmaps.main.collections;

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
import java.util.concurrent.Callable;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class CollectionsFragment extends DaggerFragment{

    @Inject
    CollectionsAdapter adapterCollections;
    @Inject
    CalculateCollections calculateCollections;

    private RecyclerView collectionRecycler;
    private ProgressBar progressBar;
    private Button mCollectionsButton;
    CompositeDisposable mDisposables = new CompositeDisposable();

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_collection,container,false);
        collectionRecycler = rootView.findViewById(R.id.collection_recycler);
        collectionRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        collectionRecycler.setAdapter(adapterCollections);
        mCollectionsButton = rootView.findViewById(R.id.button_collections);
        mCollectionsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CalculateResultTest();
            }
        });

        progressBar = rootView.findViewById(R.id.progress_bar);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mDisposables.clear();
    }

    private void CalculateResultTest(){
        Observable<ArrayList<CollectionsResult>> callable = Observable
                .fromCallable(new Callable<ArrayList<CollectionsResult>>() {
                    @Override
                    public ArrayList<CollectionsResult> call() throws Exception {
                        return calculateCollections.calculateCollectionsResult();
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

        callable.subscribe(new Observer<ArrayList<CollectionsResult>>() {
            @Override
            public void onSubscribe(Disposable d) {
                mDisposables.add(d);
                progressBar.setVisibility(View.VISIBLE);
                collectionRecycler.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onNext(ArrayList<CollectionsResult> collectionsResults) {
                progressBar.setVisibility(View.GONE);
                collectionRecycler.setVisibility(View.VISIBLE);
                adapterCollections.setItems(collectionsResults);

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });

    }
}

