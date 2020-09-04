package com.training.mvvm.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.training.mvvm.R
import com.training.mvvm.pojo.PostModel


class PostsAdapter : RecyclerView.Adapter<PostsAdapter.PostViewHolder>() {
    private var moviesList: List<PostModel> = ArrayList()
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PostViewHolder {
        return PostViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.post_item, parent, false)
        )
    }

    override fun onBindViewHolder(
        holder: PostViewHolder,
        position: Int
    ) {
        holder.titleTV.text = moviesList[position].title
        holder.userTV.text = moviesList[position].userId.toString()
        holder.bodyTV.text = moviesList[position].body
    }

    override fun getItemCount(): Int {
        return moviesList.size
    }

    fun setList(moviesList: List<PostModel>) {
        this.moviesList = moviesList
        notifyDataSetChanged()
    }

    inner class PostViewHolder(itemView: View) : ViewHolder(itemView) {
        var titleTV: TextView
        var userTV: TextView
        var bodyTV: TextView

        init {
            titleTV = itemView.findViewById(R.id.title_textView)
            userTV = itemView.findViewById(R.id.userId_textView)
            bodyTV = itemView.findViewById(R.id.body_textView)
        }
    }
}