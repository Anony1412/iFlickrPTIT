package com.sunasterisk.iflickr.data.model

import com.google.gson.annotations.SerializedName

data class PhotoSets (

    @SerializedName("photoset")
    var photoSet: List<PhotoSet>? = null
)
