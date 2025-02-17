package com.example.news_app.api

import com.example.news_app.api.model.SourcesResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsServices {

    @GET("v2/top-headlines/sources")
    fun getSources(
        @Query("ApiKey") key:String ="5569df94a254439686dc59b26e4dc1cc"
    ):Call<SourcesResponse>


}