package com.sunbeam.app1.api;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.sunbeam.app1.entity.Users;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface API {
    public static final String BASE_URL="http://192.168.134.120:2222";
    //192.168.134.120
//    public static final String BASE_URL="http://192.168.1.6:2222";
    //192.168.1.6
//    public static final String BASE_URL="http://172.18.5.144:2222";
    //172.18.5.144

    @POST("/users/register")
    public Call<JsonObject> registerUser(@Body Users user);

    @POST("/login")
    public Call<JsonObject> loginUser(@Body Users user);

    @GET("/cars/")
    public Call<JsonElement> getAllCars();
}
