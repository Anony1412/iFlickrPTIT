package com.sunasterisk.iflickr.data.source.remote.response

import com.google.gson.annotations.SerializedName
import com.sunasterisk.iflickr.data.model.PhotoSetDes

data class PhotoSetPhotosResponse(

    @SerializedName("photoset")
    var photoSetDes: PhotoSetDes? = null
)
