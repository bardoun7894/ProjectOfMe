package com.example.bardouni.rxproject.features.news

import com.example.bardouni.rxproject.RedditNewsItem
import rx.Observable

/**
 * Created by bardouni on 12/5/2017.
 */
class NewsManager {
    fun getNews(): Observable<List<RedditNewsItem>> {
        return Observable.create {
            subscriber ->

            val news = mutableListOf<RedditNewsItem>()

            for (i in 1..10) {
                news.add(RedditNewsItem(
                        "author$i",
                        "Title $i",
                        i, // number of comments
                        1457207701L - i * 200, // time
                        "http://lorempixel.com/200/200/technics/$i", // image url
                        "url"
                ))
            }

            subscriber.onNext(news)

        }
    }
}