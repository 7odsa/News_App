package com.example.news_app.ui.fragments

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.news_app.model.SourcesItem
import com.example.news_app.databinding.ItemNewsBinding

class AdapterArticles(val articles:List<SourcesItem>) :Adapter<AdapterArticles.ItemVH>() {


    data class ItemVH(val binding:ItemNewsBinding): ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemVH {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ItemVH, position: Int) {
        TODO("Not yet implemented")
    }
}