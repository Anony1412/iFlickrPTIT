package com.sunasterisk.iflickr.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.sunasterisk.iflickr.R
import com.sunasterisk.iflickr.data.model.Photo
import com.sunasterisk.iflickr.ui.adapter.viewholder.PhotoPostViewHolder
import com.sunasterisk.iflickr.ui.adapter.viewholder.PhotoProfileViewHolder
import com.sunasterisk.iflickr.ui.adapter.viewholder.PhotoViewHolder
import com.sunasterisk.iflickr.utils.PhotoType

class PhotoAdapter(
    private val viewType: Int,
    private val onClickListener: (Photo) -> Unit
) : RecyclerView.Adapter<PhotoViewHolder>() {

    private val photos = mutableListOf<Photo>()

    override fun getItemViewType(position: Int): Int = viewType

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        return when (viewType) {
            PhotoType.PHOTO_POST -> PhotoPostViewHolder(
                DataBindingUtil.inflate(
                    LayoutInflater.from(parent.context),
                    R.layout.item_photo_post,
                    parent,
                    false
                ),
                onClickListener
            )
            else -> PhotoProfileViewHolder(
                DataBindingUtil.inflate(
                    LayoutInflater.from(parent.context),
                    R.layout.item_photo_profile,
                    parent,
                    false
                ),
                onClickListener
            )
        }
    }

    override fun getItemCount(): Int = photos.size

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) =
        holder.bind(photos[position])

    fun updateData(newData: List<Photo>) {
        if (photos.isNotEmpty()) photos.clear()
        photos.addAll(newData)
        notifyDataSetChanged()
    }
}
