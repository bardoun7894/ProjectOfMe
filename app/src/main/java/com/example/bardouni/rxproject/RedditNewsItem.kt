package com.example.bardouni.rxproject

import com.example.bardouni.rxproject.commons.adapter.AdapterConstants

/**
 * Created by bardouni on 12/4/2017.
 */
data class RedditNewsItem(

    val author: String,
           val title: String,
       val numComments: Int,
            val created: Long,
       val thumbnail: String,
            val url: String
    ) : ViewType {
       override fun getViewType() = AdapterConstants.NEWS
    }