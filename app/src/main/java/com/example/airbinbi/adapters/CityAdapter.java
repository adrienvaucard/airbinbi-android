package com.example.airbinbi.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.airbinbi.R;
import com.example.airbinbi.bo.City;
import com.example.airbinbi.databinding.RowLayoutCityBinding;
import com.example.airbinbi.fragments.ListCitiesFragmentDirections;

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
        ListCitiesFragmentDirections.ActionListCitiesFragmentToListChambersFragment action = ListCitiesFragmentDirections.actionListCitiesFragmentToListChambersFragment(city);
        holder.itemView.setOnClickListener(
                (view) -> Navigation.findNavController(holder.itemView)
                        .navigate(action)
        );
        holder.binding.setCity(city);
    }

    @Override
    public int getItemCount() {
        return cityArrayList.size();
    }

}
