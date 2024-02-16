package com.sunbeam.app1.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sunbeam.app1.R;
import com.sunbeam.app1.entity.Bookings;

import java.util.List;

public class BookingListAdapter extends RecyclerView.Adapter<BookingListAdapter.MyViewHolder>
{

    Context context;
    List<Bookings> bookingsList;

    public BookingListAdapter(Context context, List<Bookings> bookingsList) {
        this.context = context;
        this.bookingsList = bookingsList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return bookingsList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView imgBooking;
        TextView carName, year, from, to, totalAmount;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imgBooking = itemView.findViewById(R.id.imgBooking);
            carName = itemView.findViewById(R.id.carName);
            year = itemView.findViewById(R.id.year);
            from = itemView.findViewById(R.id.from);
            to = itemView.findViewById(R.id.to);
            totalAmount = itemView.findViewById(R.id.totalAmount);
        }
    }
}
