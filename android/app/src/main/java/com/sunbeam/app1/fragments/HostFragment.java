package com.sunbeam.app1.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.sunbeam.app1.R;
import com.sunbeam.app1.adapter.CarListAdapter;
import com.sunbeam.app1.entity.Cars;

import java.util.ArrayList;
import java.util.List;

public class HostFragment extends Fragment {

    RecyclerView recyclerView;
    Button addCar;
    CarListAdapter carListAdapter;
    List<Cars> bookingCarList;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_host, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recyclerView);
        bookingCarList = new ArrayList<>();
        addCar = view.findViewById(R.id.addCar);
        carListAdapter = new CarListAdapter(getContext(),bookingCarList);
    }
}