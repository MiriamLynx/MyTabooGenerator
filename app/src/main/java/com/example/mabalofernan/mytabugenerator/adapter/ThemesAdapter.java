package com.example.mabalofernan.mytabugenerator.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mabalofernan.mytabugenerator.R;
import com.example.mabalofernan.mytabugenerator.model.Theme;

import java.util.List;

public class ThemesAdapter extends RecyclerView.Adapter<ThemesAdapter.ThemesViewHolder> {

    private List<Theme> dataSet;

    public ThemesAdapter(List<Theme> dataSet){
        this.dataSet = dataSet;
    }

    @NonNull
    @Override
    public ThemesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.themes_view, parent, false);
        ThemesViewHolder themesViewHolder = new ThemesViewHolder(listItem);
        return themesViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ThemesViewHolder themesViewHolder, int i) {
        themesViewHolder.text.setText(dataSet.get(i).getDescription());
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public static  class ThemesViewHolder extends RecyclerView.ViewHolder {

        public TextView text;

        public ThemesViewHolder(@NonNull View itemView) {
            super(itemView);
            this.text = itemView.findViewById(R.id.themesDescriptionTextView);
        }

    }

}
