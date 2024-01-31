package com.example.countrynews

import com.example.countrynews.data.News
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {


    @GET("v2/top-headlines?country=us&category=business&apiKey=6fc4d0a939e44cbba94469ab99730dd0")
    fun getNews(
    ):Call<News>


    @GET("v2/top-headlines")
    fun getModifiedNews(
        @Query("country") country:String,
        @Query("category") category: String,
        @Query("apiKey") apiKey: String="6fc4d0a939e44cbba94469ab99730dd0"
    ):Call<News>


}