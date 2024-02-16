package com.sunbeam.app1.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.sunbeam.app1.R;
import com.sunbeam.app1.adapter.CarListAdapter;
import com.sunbeam.app1.api.RetrofitClient;
import com.sunbeam.app1.entity.Cars;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
        getAllCars();
    }

    public void  getAllCars(){
//        RetrofitClient.getInstance().getApi().getAllCars().enqueue(new Callback<JsonObject>() {
//            @Override
//            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
//                JsonObject jsonObject = response.body();
//                JsonArray array = response.body().getAsJsonArray();
//                Log.e("Home",jsonObject.getAsString().toString());
//                Log.e("Home",response.body().getAsString().toString());
//                if (array.size() != 0){
////                    JsonArray array = jsonObject.getAsJsonArray();
//                }
//                else {
//                    Toast.makeText(getContext(),"No cars to be displayed",Toast.LENGTH_SHORT).show();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<JsonObject> call, Throwable t) {
//                Log.e("Home",t.toString());
//                Log.e("Home",call.toString());
//                Toast.makeText(getContext(),"Something went wrong while fetching cars",Toast.LENGTH_SHORT).show();
//            }
//        });
        RetrofitClient.getInstance().getApi().getAllCars().enqueue(new Callback<JsonElement>() {
            @Override
            public void onResponse(Call<JsonElement> call, Response<JsonElement> response) {
//                Log.e("Home",response.body().toString());
//                Log.e("Home",response.isSuccessful()+" mmm");
                if (response.isSuccessful()){
                    JsonElement element = response.body();
//                    Log.e("Home",element.toString());
                    if (element.isJsonObject()){
                        JsonObject jsonObject = element.getAsJsonObject();
//                        Log.e("Home",jsonObject.toString());
                    } else if (element.isJsonArray()) {
                        JsonArray array = element.getAsJsonArray();
                        Log.e("Home",array.toString()+"  mmm");
                        Log.e("Home",array.get(0).toString()+"  mmm");
                        Log.e("Home",array.get(0).getAsJsonObject().get("model_name").toString()+"  mmm");
                        Log.e("Home",array.size()+"  mmm");
                        if (!array.isJsonNull()){

                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<JsonElement> call, Throwable t) {

            }
        });
    }
}