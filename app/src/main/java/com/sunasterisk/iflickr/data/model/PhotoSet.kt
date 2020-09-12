package com.sunasterisk.iflickr.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PhotoSet (

    @SerializedName("id")
    var id: String? = "",

    @SerializedName("owner")
    var owner: String? = "",

    @SerializedName("username")
    var username: String? = "",

    @SerializedName("primary")
    var primary: String? = "",

    @SerializedName("secret")
    var secret: String? = "",

    @SerializedName("server")
    var server: String? = "",

    @SerializedName("farm")
    var farm: String? = "",

    @SerializedName("count_photo")
    var countPhoto: String? = "",

    @SerializedName("title")
    var title: PhotoSetTitle? = null
): Parcelable
