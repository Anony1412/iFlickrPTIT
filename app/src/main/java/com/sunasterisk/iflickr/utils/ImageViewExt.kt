package com.sunasterisk.iflickr.utils

import android.util.Log
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.sunasterisk.iflickr.R

fun ImageView.applyGlide(url: String?, requestOptions: RequestOptions) {
    Log.d("ImageView+", "photoUrl = $url")
    Glide.with(context)
        .load(url)
        .apply(requestOptions)
        .placeholder(R.drawable.ic_launcher_foreground)
        .into(this)
}
