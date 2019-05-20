package com.example.collectionsandmaps.main.maps;

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

public class MapsAdapter extends RecyclerView.Adapter<MapsAdapter.ViewHolder> {
    private ArrayList<MapsResult> mapsList = new ArrayList<>();

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private CardView cardView;
        @BindView(R.id.info_name_test_maps) TextView name_test_maps;
        @BindView(R.id.info_tree_map) TextView tree_map;
        @BindView(R.id.info_hash_map) TextView hash_map;

        public ViewHolder(@NonNull CardView itemView) {
            super(itemView);
            cardView = itemView;
            ButterKnife.bind(this, cardView);
        }
    }

    public void setItems(ArrayList<MapsResult> mapsList) {
        this.mapsList = mapsList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mapsList.size();
    }

    @NonNull
    @Override
    public MapsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        CardView cardView = (CardView) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list_maps, viewGroup, false);
        return new ViewHolder(cardView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.name_test_maps.setText(mapsList.get(i).nameTest);
        viewHolder.tree_map.setText(Long.toString(mapsList.get(i).timeTreeMap));
        viewHolder.hash_map.setText(Long.toString(mapsList.get(i).timeHashMap));
    }
}
