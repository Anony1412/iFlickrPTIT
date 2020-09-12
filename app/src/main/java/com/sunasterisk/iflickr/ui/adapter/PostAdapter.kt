package com.sunasterisk.iflickr.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.sunasterisk.iflickr.R
import com.sunasterisk.iflickr.data.model.Post
import com.sunasterisk.iflickr.ui.adapter.viewholder.PostViewHolder

class PostAdapter(
    private val onClickListener: (Post) -> Unit
) : RecyclerView.Adapter<PostViewHolder>() {

    private val posts = mutableListOf<Post>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder =
        PostViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_post,
                parent,
                false
            ),
            onClickListener
        )

    override fun getItemCount(): Int = posts.size

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) =
        holder.bind(posts[position])

    fun updateData(newData: List<Post>) {
        if (posts.isNotEmpty()) posts.clear()
        posts.addAll(newData)
        notifyDataSetChanged()
    }
}
