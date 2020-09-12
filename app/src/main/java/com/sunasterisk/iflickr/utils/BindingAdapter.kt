package com.sunasterisk.iflickr.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions

object BindingAdapter {

    private val avatarRequestOptions = createRequestOptions(Constants.AVATAR_RADIUS)

    private val photoRequestOptions = createRequestOptions(Constants.PHOTO_RADIUS)

    private fun createRequestOptions(radius: Int) = RequestOptions().apply {
        transform(CenterCrop(), RoundedCorners(radius))
    }

    @JvmStatic
    @BindingAdapter("avatarUrl")
    fun loadAvatar(image: ImageView, avatarUrl: String) =
        image.applyGlide(avatarUrl, avatarRequestOptions)

    @JvmStatic
    @BindingAdapter("photoUrl")
    fun loadPhoto(image: ImageView, photoUrl: String) {
        image.applyGlide(photoUrl, photoRequestOptions)
    }
}
