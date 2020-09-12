package com.sunasterisk.iflickr.data.source.remote.response

import com.google.gson.annotations.SerializedName
import com.sunasterisk.iflickr.data.model.PhotoSets

data class PhotoSetsResponse (

    @SerializedName("photosets")
    var photosets: PhotoSets? = null
)
