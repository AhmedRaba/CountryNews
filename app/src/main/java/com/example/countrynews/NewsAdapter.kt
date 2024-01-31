package com.example.countrynews

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.countrynews.data.News
import com.example.countrynews.databinding.ItemNewsBinding
import com.squareup.picasso.Picasso

class NewsAdapter(private val newsData: News) : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    inner class NewsViewHolder(val binding: ItemNewsBinding) : RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        return NewsViewHolder(
            ItemNewsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return newsData.articles.size
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val currentItem = newsData.articles[position]

        Picasso.get().load(currentItem.urlToImage).into(holder.binding.newsImage)

        holder.binding.newTitle.text = currentItem.title
    }
}