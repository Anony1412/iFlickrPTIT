package com.sunasterisk.iflickr.data.source.remote.response

import com.google.gson.annotations.SerializedName
import com.sunasterisk.iflickr.data.model.User

data class UserResponse (

    @SerializedName("user")
    var user: User? = null
)
