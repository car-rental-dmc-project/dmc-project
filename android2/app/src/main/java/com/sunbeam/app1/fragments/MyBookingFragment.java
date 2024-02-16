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
import com.sunbeam.app1.adapter.BookingListAdapter;
import com.sunbeam.app1.entity.Bookings;

import java.util.ArrayList;
import java.util.List;

public class MyBookingFragment extends Fragment {

    RecyclerView recyclerView;
    List<Bookings> bookingsList;
    BookingListAdapter bookingListAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_booking, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recyclerView);
        bookingsList = new ArrayList<>();
        bookingListAdapter = new BookingListAdapter(getContext(),bookingsList);
        recyclerView.setAdapter(bookingListAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),1));
    }
}