package com.sunasterisk.iflickr.data.model

import com.google.gson.annotations.SerializedName

data class Comment (

    @SerializedName("id")
    var id: String? = "",

    @SerializedName("authorname")
    var authorName: String? = "",

    @SerializedName("iconserver")
    var iconServer: String? = "",

    @SerializedName("iconfarm")
    var iconFarm: String? = "",

    @SerializedName("realname")
    var realName: String? = "",

    @SerializedName("_content")
    var content: String? = ""
)
