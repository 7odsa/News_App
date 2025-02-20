package com.example.news_app.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.news_app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var adapter: AdapterMainCategories

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setRecyclerView()

    }

    private fun setRecyclerView() {
        adapter= AdapterMainCategories()
        binding.rvCategories.adapter=adapter
    }


}
