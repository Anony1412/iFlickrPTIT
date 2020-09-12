package com.sunasterisk.iflickr.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PhotoSetDes(

    @SerializedName("id")
    var id: String? = "",

    @SerializedName("primary")
    var primary: String? = "",

    @SerializedName("owner")
    var owner: String? = "",

    @SerializedName("ownername")
    var ownerName: String? = "",

    @SerializedName("photo")
    var photos: List<Photo>? = null
) : Parcelable
