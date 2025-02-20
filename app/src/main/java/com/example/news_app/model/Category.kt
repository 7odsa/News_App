package com.example.news_app.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.news_app.R

class Category(val name: String,
               @StringRes val nameResId: Int,
               @DrawableRes val imgResId: Int) {
    companion object{
        fun getCategories():List<Category>{
            return listOf(
                Category("general", R.string.app_name,R.drawable.img)
            )
        }
    }
}