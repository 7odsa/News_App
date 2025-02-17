package com.example.news_app

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.news_app.api.ApiManager
import com.example.news_app.api.model.SourcesResponse
import com.example.news_app.databinding.ActivityMainBinding
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val response = ApiManager.newsServices()
            .getSources()
            .enqueue(object : Callback<SourcesResponse> {
                override fun onResponse(
                    call: Call<SourcesResponse>,
                    response: Response<SourcesResponse>
                ) {
                    if (!response.isSuccessful)
                        return
                    Log.e("WWWW ", response.body()?.status.toString())

                }

                override fun onFailure(call: Call<SourcesResponse>, error: Throwable) {
                    error.message?.let { Log.e("WWWW0", it) }
                }
            })

    }
}
