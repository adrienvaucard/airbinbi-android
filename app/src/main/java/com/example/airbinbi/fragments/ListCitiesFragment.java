package com.example.airbinbi.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.airbinbi.R;
import com.example.airbinbi.adapters.CityAdapter;
import com.example.airbinbi.bo.City;
import com.example.airbinbi.viewmodels.ListCityFragmentViewModel;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ListCitiesFragment extends Fragment {
    OkHttpClient client;
    private RecyclerView rv;
    private CityAdapter adapter;
    private ListCityFragmentViewModel vm;
    private static final String TAG = "CityListFragment";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        client = new OkHttpClient();
        vm = new ViewModelProvider(this).get(ListCityFragmentViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_cities, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        initializeCities();
        Observer<ArrayList<City>> observerList = contacts -> {
            adapter.setCityArrayList(contacts);
            rv.scrollToPosition(adapter.getItemCount() - 1);
        };
        vm.getCityArrayList().observe(getViewLifecycleOwner(), observerList);

        if (vm.getCityArrayList().getValue().isEmpty()) {
            fetchCities();
        }


        super.onViewCreated(view, savedInstanceState);
    }

    private void initializeCities() {
        rv = getView().findViewById(R.id.recyclerViewCity);
        adapter = new CityAdapter();
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        rv.setAdapter(adapter);
    }

    public void fetchCities() {
        Request requestMsg = new Request.Builder()
                .url("https://flutter-learning.mooo.com/villes")
                .build();
        client.newCall(requestMsg).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                Log.e(TAG, "onFailure: " + "getCities - " + e.getMessage());
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                if (response.code() == 200) {
                    ArrayList<City> alCities = new Gson().fromJson(
                            response.body().string(),
                            new TypeToken<ArrayList<City>>(){}.getType()
                    );
                    Log.i(TAG, "onResponse: " + alCities.toString());
                    vm.getCityArrayList().postValue(alCities);
                } else {
                    Log.e(TAG, "onResponse: " + "Error" );
                }
            }
        });
    }
}