package com.example.airbinbi.adapters;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.airbinbi.databinding.RowLayoutCityBinding;

public class CityViewHolder extends RecyclerView.ViewHolder {
    RowLayoutCityBinding binding;

    public CityViewHolder(@NonNull RowLayoutCityBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }
}
