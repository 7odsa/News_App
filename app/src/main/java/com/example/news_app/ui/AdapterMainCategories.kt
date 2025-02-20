package com.example.news_app.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.news_app.databinding.LeftCategoryItemBinding
import com.example.news_app.databinding.RightCategoryItemBinding

class AdapterMainCategories() :
    Adapter<AdapterMainCategories.BaseItemVH>() {

    abstract class BaseItemVH(val view: View) : ViewHolder(view) {
        abstract fun bindData()
    }

    class RightItemVH(val binding: RightCategoryItemBinding) : BaseItemVH(binding.root) {
        override fun bindData() {

        }
    }

    class LeftItemVH(val binding: LeftCategoryItemBinding) : BaseItemVH(binding.root) {
        override fun bindData() {

        }
    }

    var onCreateCounter: Int = 0
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseItemVH {
        val item: BaseItemVH

        if (onCreateCounter % 2 == 0) {
            val binding =
                RightCategoryItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            item = RightItemVH(binding)
        } else {
            val binding =
                LeftCategoryItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            item = LeftItemVH(binding)
        }
        onCreateCounter++
        return item
    }


    override fun getItemCount(): Int {

        return 100
    }

    override fun onBindViewHolder(holder: BaseItemVH, position: Int) {
        holder.bindData()
    }
}