package com.sunasterisk.iflickr.ui.adapter.viewholder

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.sunasterisk.iflickr.data.model.Photo
import com.sunasterisk.iflickr.databinding.ItemPhotoPostBinding
import com.sunasterisk.iflickr.databinding.ItemPhotoProfileBinding

abstract class PhotoViewHolder(
    photoBinding: ViewDataBinding,
    onClickListener: (Photo) -> Unit
) : RecyclerView.ViewHolder(photoBinding.root) {

    protected var photo: Photo? = null

    init {
        itemView.setOnClickListener {
            photo?.let {
                onClickListener(it)
            }
        }
    }

    abstract fun bind(photo: Photo)
}

class PhotoPostViewHolder(
    private var photoPostBinding: ItemPhotoPostBinding,
    onClickListener: (Photo) -> Unit
) : PhotoViewHolder(photoPostBinding, onClickListener) {

    override fun bind(photo: Photo) {
        this.photo = photo
        photoPostBinding.run {
            this.photo = photo
            executePendingBindings()
        }
    }
}

class PhotoProfileViewHolder(
    private var photoProfileBinding: ItemPhotoProfileBinding,
    onClickListener: (Photo) -> Unit
) : PhotoViewHolder(photoProfileBinding, onClickListener) {

    override fun bind(photo: Photo) {
        this.photo = photo
        photoProfileBinding.run {
            this.photo = photo
            executePendingBindings()
        }
    }
}
