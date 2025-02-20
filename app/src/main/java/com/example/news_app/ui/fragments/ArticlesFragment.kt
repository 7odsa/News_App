package com.example.news_app.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.news_app.api.ApiManager
import com.example.news_app.databinding.FragmentArticlesBinding
import com.example.news_app.model.Articles
import com.example.news_app.model.ArticlesItem
import com.example.news_app.model.SourcesItem
import com.example.news_app.model.SourcesResponse
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ArticlesFragment : Fragment() {


    lateinit var binding: FragmentArticlesBinding

    var sourceChannelsItems: List<SourcesItem?>? = null
    var ArticleItems: List<ArticlesItem?>? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentArticlesBinding.inflate(layoutInflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getNewsChannelsAndSetTabs()
//        setArticlesAdapter()
    }

    private fun getNewsChannelsAndSetTabs() {
        getNewsChannelsFromAPI()
    }

    private fun setArticlesAdapter() {
//         TODO
//        getArticlesFromApi()
    }

    private fun getArticlesFromApi(category: String, sources: String) {
        val response = ApiManager
            .articlesServices()
            .getArticles(sources = sources)
            .enqueue(object : Callback<Articles> {
                override fun onResponse(
                    call: Call<Articles>,
                    response: Response<Articles>
                ) {
                    if (!response.isSuccessful) {
                        Log.e("WWWW ", response.body()?.message.toString())
                        return
                    }

                    Log.e("WWWW ", response.body()?.articles.toString())
                    ArticleItems = response.body()?.articles
                }

                override fun onFailure(call: Call<Articles>, error: Throwable) {
                    error.message?.let { Log.e("WWWW0", it) }
                }
            })
    }

    private fun setNewsTabs() {
        if (sourceChannelsItems == null) return

        for (item in sourceChannelsItems!!) {
            if (item != null) {
                val tab = binding.tabsNewsChannels.newTab()
                tab.text = item.name
                tab.tag = item
                binding.tabsNewsChannels.addTab(tab)
            }
        }


        sourceChannelsItems!![0]?.let { getArticlesFromApi(it.category!!, it.id!!) }


        binding.tabsNewsChannels.addOnTabSelectedListener(object : OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {

                val sourcesItem = tab?.tag as SourcesItem

                if (sourcesItem.category == null || sourcesItem.id == null) return

                getArticlesFromApi(sourcesItem.category, sourcesItem.id)

            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
//                TODO("Not yet implemented")
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
//                TODO("Not yet implemented")
            }

        })

    }


    private fun getNewsChannelsFromAPI() {
        val response = ApiManager.newsServices()
            .getSources(category = null)
            .enqueue(object : Callback<SourcesResponse> {
                override fun onResponse(
                    call: Call<SourcesResponse>,
                    response: Response<SourcesResponse>
                ) {
                    if (!response.isSuccessful)
                        return

                    Log.e("WWWW ", response.body()?.status.toString())

                    sourceChannelsItems = response.body()?.sources

                    setNewsTabs()
                }

                override fun onFailure(call: Call<SourcesResponse>, error: Throwable) {
                    error.message?.let { Log.e("WWWW0", it) }
                    Toast.makeText(
                        this@ArticlesFragment.requireContext(),
                        "Connection Error!!!",
                        Toast.LENGTH_LONG
                    )
                        .show()
                }
            })
    }

}