package com.example.bardouni.rxproject.commons.adapter

import android.support.v4.util.SparseArrayCompat
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.example.bardouni.rxproject.RedditNewsItem
import com.example.bardouni.rxproject.ViewType
import com.example.bardouni.rxproject.ViewTypeDelegateAdapter


class NewsAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private  var items: ArrayList<ViewType>
    private var delegateAdapters = SparseArrayCompat<ViewTypeDelegateAdapter>()

    private val loadingItem = object : ViewType {
        override fun getViewType() = AdapterConstants.LOADING

    }


    init {

            delegateAdapters.put(AdapterConstants.LOADING, LoadingDelegateAdapter())

                   delegateAdapters.put(AdapterConstants.NEWS, NewsDelegateAdapter())
            items = ArrayList()

            items.add(loadingItem)

    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        delegateAdapters.get(getItemViewType(position)).onBindViewHolder(holder, this.items[position])
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return delegateAdapters.get(viewType).onCreateViewHolder(parent)
    }

    override fun getItemCount(): Int {
        return items.size
    }
    fun addNews(news: List<RedditNewsItem>) {
               // first remove loading and notify
                val initPosition = items.size - 1
               items.removeAt(initPosition)
}
}