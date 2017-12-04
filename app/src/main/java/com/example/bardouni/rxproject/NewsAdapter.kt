package com.example.bardouni.rxproject

import android.support.v4.util.SparseArrayCompat
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.example.bardouni.rxproject.commons.adapter.AdapterConstants
import com.example.bardouni.rxproject.commons.adapter.LoadingDelegateAdapter
import com.example.bardouni.rxproject.commons.adapter.ViewType
import com.example.bardouni.rxproject.commons.adapter.ViewTypeDelegateAdapter

 
class NewsAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private  var items: ArrayList<ViewType>
    private var delegateAdapters = SparseArrayCompat<ViewTypeDelegateAdapter>()

    private val loadingItem = object : ViewType {
        override fun getViewType() = AdapterConstants.LOADING

    }


    init {
                delegateAdapters.put(AdapterConstants.LOADING, LoadingDelegateAdapter())
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
}