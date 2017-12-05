package com.example.bardouni.rxproject


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.bardouni.rxproject.commons.adapter.NewsAdapter
import com.example.bardouni.rxproject.commons.extensions.inflate
import com.example.bardouni.rxproject.features.news.NewsManager
import kotlinx.android.synthetic.main.fragment_news.*


class NewsFragment : Fragment() {

    private val newsList by lazy {
        news_list
    }
    private val newsManager by lazy { NewsManager() }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

//        val view= inflater!!.inflate(R.layout.fragment_news, container, false)
        val view=container?.inflate(R.layout.fragment_news)

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        newsList.setHasFixedSize(true) // <-- Lazy executed!
        newsList.layoutManager = LinearLayoutManager(context)
        initAdapter()
        if (savedInstanceState == null) {
            requestNews()

        }
    }

    private fun requestNews() {
//            (news_list.adapter as NewsAdapter).addNews(news)

    }

    private fun initAdapter() {
        if (news_list.adapter == null) {

                news_list.adapter = NewsAdapter()
            }
        }
    }

