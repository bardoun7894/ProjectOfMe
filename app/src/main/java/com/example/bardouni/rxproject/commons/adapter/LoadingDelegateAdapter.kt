package com.example.bardouni.rxproject.commons.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.example.bardouni.rxproject.R
import com.example.bardouni.rxproject.inflate

class LoadingDelegateAdapter: ViewTypeDelegateAdapter {

    override fun onCreateViewHolder(parent: ViewGroup)=TurnsViewHolder(parent)

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {

          }
}
class TurnsViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
                parent.inflate(R.layout.news_item_loading)) {
        }