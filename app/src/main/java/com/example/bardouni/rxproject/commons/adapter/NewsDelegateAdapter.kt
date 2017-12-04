package com.example.bardouni.rxproject.commons.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.example.bardouni.rxproject.R
import com.example.bardouni.rxproject.RedditNewsItem
import com.example.bardouni.rxproject.ViewType
import com.example.bardouni.rxproject.ViewTypeDelegateAdapter
import com.example.bardouni.rxproject.commons.extensions.inflate
import getFriendlyTime

/**
 * Created by bardouni on 12/4/2017.
 */
class NewsDelegateAdapter : ViewTypeDelegateAdapter {

       override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
              return TurnsViewHolder(parent)
         }

      override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
               holder as TurnsViewHolder
              holder.bind(item as RedditNewsItem)
            }

       class TurnsViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
                    parent.inflate(R.layout.news_item)) {

               fun bind(item: RedditNewsItem) = with(itemView) {
                       //Picasso.with(itemView.context).load(item.thumbnail).into(img_thumbnail)
                       img_thumbnail.loadImg(item.thumbnail)
                     description.text = item.title
                       author.text = item.author
                      comments.text = "${item.numComments} comments"
                        time.text = item.created.getFriendlyTime()
                    }
            }
     }