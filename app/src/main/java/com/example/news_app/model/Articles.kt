package com.example.news_app.model

import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

@Parcelize
data class Articles(
    val totalResults: Int? = null,

    val articles: List<ArticlesItem?>? = null,
    val status: String? = null,

    val code: String? = null,

    val message: String? = null
) : Parcelable

@Parcelize
data class ArticlesItem(
    val publishedAt: String? = null,
    val author: String? = null,
    val urlToImage: String? = null,
    val description: String? = null,
    val source: Source? = null,
    val title: String? = null,
    val url: String? = null,
    val content: String? = null,
    val code: String? = null,
    val message: String? = null
) : Parcelable

@Parcelize
data class Source(
    val name: String? = null,
    val id: String? = null
) : Parcelable
