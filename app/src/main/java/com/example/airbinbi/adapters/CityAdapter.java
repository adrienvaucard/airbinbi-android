package com.example.airbinbi.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.airbinbi.R;
import com.example.airbinbi.bo.City;
import com.example.airbinbi.databinding.RowLayoutCityBinding;

import java.util.ArrayList;

public class CityAdapter extends RecyclerView.Adapter<CityViewHolder> {
    ArrayList<City> cityArrayList;

    public CityAdapter() {
        this.cityArrayList = cityArrayList;
    }

    public void setCityArrayList(ArrayList<City> cityArrayList) {
        this.cityArrayList = cityArrayList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CityViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RowLayoutCityBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.row_layout_city,
                parent,
                false
        );
        return new CityViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CityViewHolder holder, int position) {
        City city = cityArrayList.get(position);
        holder.binding.setCity(city);
    }

    @Override
    public int getItemCount() {
        return cityArrayList.size();
    }

}
