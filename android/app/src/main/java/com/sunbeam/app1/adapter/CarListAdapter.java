package com.sunbeam.app1.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sunbeam.app1.R;
import com.sunbeam.app1.entity.Cars;

import java.util.List;

public class CarListAdapter extends RecyclerView.Adapter<CarListAdapter.MyViewHolder>
{
    Context context;
    List<Cars> carsList;

    public CarListAdapter(Context context, List<Cars> cars) {
        this.context = context;
        this.carsList = cars;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_cars,null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.carModel.setText(carsList.get(position).getName());
        holder.year.setText(carsList.get(position).getYear());
        holder.seats.setText(carsList.get(position).getSeats());
        holder.trans.setText(carsList.get(position).getTransmission());
        holder.fuel.setText(carsList.get(position).getFuelType());
    }

    @Override
    public int getItemCount() {
        return carsList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imgCar;
        TextView carModel, year, trans, fuel, seats;
        Button btnBook;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            carModel = itemView.findViewById(R.id.carModel);
            imgCar =itemView.findViewById(R.id.imgCar);
            year = itemView.findViewById(R.id.year);
            trans = itemView.findViewById(R.id.trans);
            fuel = itemView.findViewById(R.id.fuel);
            seats = itemView.findViewById(R.id.year);
            btnBook = itemView.findViewById(R.id.btnBook);
        }
    }
}
