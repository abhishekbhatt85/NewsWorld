package com.example.newsworld.common.networks;

import com.example.newsworld.feature.newslist.model.News;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsApi {
  @GET("top-headlines")
  Call<News> topNews(@Query("country") String country,
      @Query("apiKey") String apiKey,
      @Query("pageSize") int pageCount);
}