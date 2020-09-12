package com.sunasterisk.iflickr.data.source.remote.response

import com.google.gson.annotations.SerializedName
import com.sunasterisk.iflickr.data.model.Comments

data class PhotoCommentsResponse (

    @SerializedName("comments")
    var comments: Comments? = null
)
