package com.example.news_api.api;

import com.example.news_api.model.newsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsServices {
    @GET("v2/top-headlines")
    Call<newsResponse> getCurrentNews(
        @Query("country") String country ,//q means default word to search
        @Query("apiKey") String apikey
    );
}
