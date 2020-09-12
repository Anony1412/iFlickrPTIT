package com.sunasterisk.iflickr.ui.adapter.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.sunasterisk.iflickr.data.model.Photo
import com.sunasterisk.iflickr.data.model.Post
import com.sunasterisk.iflickr.databinding.ItemPostBinding
import com.sunasterisk.iflickr.ui.adapter.PhotoAdapter
import com.sunasterisk.iflickr.utils.PhotoType

class PostViewHolder(
    private val itemPostBinding: ItemPostBinding,
    onClickListener: (Post) -> Unit
) : RecyclerView.ViewHolder(itemPostBinding.root) {

    private var post: Post? = null

    init {
        itemView.setOnClickListener {
            post?.let { onClickListener(it) }
        }
    }

    private val photoAdapter by lazy {
        PhotoAdapter(PhotoType.PHOTO_POST) {
            onPhotoItemClick(it)
        }
    }

    private fun onPhotoItemClick(photo: Photo) {

    }

    fun bind(post: Post) {
        this.post = post
        itemPostBinding.post = post
        itemPostBinding.pagerPhotoSet.adapter = photoAdapter
        post.photos?.let {
            photoAdapter.updateData(it)
        }
        itemPostBinding.executePendingBindings()
    }
}
