package com.sunasterisk.iflickr.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Photos (

    @SerializedName("total")
    var total: String? = "",

    @SerializedName("photo")
    var photos: List<Photo>? = null
): Parcelable
