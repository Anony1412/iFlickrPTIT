package com.sunasterisk.iflickr.data.source.remote.response

import com.google.gson.annotations.SerializedName
import com.sunasterisk.iflickr.data.model.Photos

data class PublicPhotosResponse (

    @SerializedName("photos")
    var photos: Photos? = null
)
