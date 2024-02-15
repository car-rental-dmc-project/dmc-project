package com.sunbeam.app1.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sunbeam.app1.R;
import com.sunbeam.app1.adapter.CarListAdapter;
import com.sunbeam.app1.entity.Cars;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    RecyclerView recyclerView;
    List<Cars> carsList;
    CarListAdapter carListAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recyclerView);
        carsList = new ArrayList<>();
        carListAdapter = new CarListAdapter(getContext(),carsList);
        recyclerView.setAdapter(carListAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),1));

    }
}