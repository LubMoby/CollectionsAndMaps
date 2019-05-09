package com.example.collectionsandmaps.collections;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.collectionsandmaps.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CollectionsAdapter extends RecyclerView.Adapter<CollectionsAdapter.ViewHolder> {
    private ArrayList<CollectionsTestResult> collectionsList;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private CardView cardView;
        @BindView(R.id.info_name_test) TextView name_test;
        @BindView(R.id.info_array_list) TextView array_list_test;
        @BindView(R.id.info_linked_list) TextView linked_list_test;
        @BindView(R.id.info_copyonwrite_list) TextView copyonwrite_list_test;

        public ViewHolder(@NonNull CardView itemView) {
            super(itemView);
            cardView = itemView;
            ButterKnife.bind(this, cardView);
        }
    }

    CollectionsAdapter(ArrayList<CollectionsTestResult> collectionsList) {
        this.collectionsList = collectionsList;
    }

    @Override
    public int getItemCount() {
        return collectionsList.size();
    }

    public void setItems(ArrayList<CollectionsTestResult> collectionsList) {
        this.collectionsList = collectionsList;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public CollectionsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        CardView cardView = (CardView) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list, viewGroup, false);
        return new ViewHolder(cardView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        if(i == 0){
            viewHolder.name_test.setText("Tests for collections");
            viewHolder.array_list_test.setText("ArrayList");
            viewHolder.linked_list_test.setText("LinkedList");
            viewHolder.copyonwrite_list_test.setText("CopyOnWriteArrayList");
        }else {
            viewHolder.name_test.setText(collectionsList.get(i).nameTest);
            viewHolder.array_list_test.setText(Long.toString(collectionsList.get(i).timeForArrayList));
            viewHolder.linked_list_test.setText(Long.toString(collectionsList.get(i).timeForLinkedList));
            viewHolder.copyonwrite_list_test.setText(Long.toString(collectionsList.get(i).timeForCopyOnWriteArrayList));
        }
    }
}
