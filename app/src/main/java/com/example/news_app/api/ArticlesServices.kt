package com.example.news_app.api

import com.example.news_app.model.Articles
import com.example.news_app.model.SourcesResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ArticlesServices {
    @GET("v2/top-headlines")
    fun getArticles(
        @Query("ApiKey") key: String = "5569df94a254439686dc59b26e4dc1cc",
        @Query("category") category: String? = null,
        @Query("sources") sources: String? = null,
        @Query("q") q: String? = null
    ): Call<Articles>
}