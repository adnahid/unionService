package com.example.unionservice.Api2;

import com.example.unionservice.model.FlowerResponse;

import java.util.List;


import retrofit2.Call;
import retrofit2.http.GET;

public interface FlowerInterface {

    @GET("flowers.json")
    Call<List<FlowerResponse>> flower();
}
