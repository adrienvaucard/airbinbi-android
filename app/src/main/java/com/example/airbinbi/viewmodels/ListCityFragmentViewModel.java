package com.example.airbinbi.viewmodels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.airbinbi.bo.City;

import java.util.ArrayList;

public class ListCityFragmentViewModel extends ViewModel {
    MutableLiveData<ArrayList<City>> arrayListCity;

    public MutableLiveData<ArrayList<City>> getCityArrayList() {
        if (arrayListCity == null) {
            this.arrayListCity = new MutableLiveData<>(new ArrayList<City>());
        }

        return this.arrayListCity;
    }
}
