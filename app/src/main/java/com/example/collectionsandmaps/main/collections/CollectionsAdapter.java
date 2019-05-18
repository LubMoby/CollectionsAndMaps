package com.example.collectionsandmaps.main.collections;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.collectionsandmaps.R;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Set;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CollectionsAdapter extends RecyclerView.Adapter<CollectionsAdapter.ViewHolder> {
    private ArrayList<LinkedHashMap<String, Long[]>> collectionsList = new ArrayList<>();

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

    @Override
    public int getItemCount() {
        return collectionsList.size();
    }

    public void setItems(ArrayList<LinkedHashMap<String, Long[]>> collectionsList) {
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
        LinkedHashMap<String, Long[]> linkedHashMap = collectionsList.get(i);
        Set<String> keySet = linkedHashMap.keySet();
        String key = "";
        for (String k:keySet) {key = k;}
        Long[] valuesResult = linkedHashMap.get(key);
        viewHolder.name_test.setText(key.toString());
        viewHolder.array_list_test.setText(valuesResult[0].toString());
        viewHolder.linked_list_test.setText(valuesResult[1].toString());
        viewHolder.copyonwrite_list_test.setText(valuesResult[2].toString());
    }
}
