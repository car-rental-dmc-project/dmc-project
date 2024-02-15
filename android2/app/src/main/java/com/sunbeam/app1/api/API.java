package com.sunbeam.app1.api;

import com.google.gson.JsonObject;
import com.sunbeam.app1.entity.Users;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface API {
    public static final String BASE_URL="http://localhost:2222";

    @POST("/users/register")
    public Call<JsonObject> registerUser(@Body Users user);

    @POST("/login")
    public Call<JsonObject> loginUser(@Body Users user);

    @GET("/cars/")
    public Call<JsonObject> getAllMovies();
}
