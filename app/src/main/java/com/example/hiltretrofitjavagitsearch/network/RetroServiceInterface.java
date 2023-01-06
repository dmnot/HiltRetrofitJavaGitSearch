package com.example.hiltretrofitjavagitsearch.network;

import com.example.hiltretrofitjavagitsearch.model.RecyclerList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetroServiceInterface {
    @GET("repositories")
    Call<RecyclerList> getDataFromGithubApi(@Query("q") String query);
}
