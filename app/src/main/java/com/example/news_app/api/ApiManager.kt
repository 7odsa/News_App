package com.example.news_app.api

import android.util.Log
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiManager {

    companion object {
        var retrofit: Retrofit? = null

        private fun initRetrofit(): Retrofit {
            if (retrofit == null) {
                val loggingInterceptor = HttpLoggingInterceptor { msg: String ->
                    Log.e("api111", msg)
                }

                val okHttpClient = OkHttpClient.Builder()
                    .addInterceptor(loggingInterceptor)
                    .build()
                retrofit =
                    Retrofit.Builder()
                        .client(okHttpClient)
                        .baseUrl("https://newsapi.org/")
                        .addConverterFactory(
                            GsonConverterFactory.create()
                        )
                        .build()
            }

            return retrofit!!
        }

        fun newsServices(): NewsServices {
            return initRetrofit().create(NewsServices::class.java)
        }

        fun articlesServices(): ArticlesServices {
            return initRetrofit().create(ArticlesServices::class.java)
        }
    }

}
