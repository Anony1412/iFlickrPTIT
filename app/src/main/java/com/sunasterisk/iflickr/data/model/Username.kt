package com.sunasterisk.iflickr.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Username (

    @SerializedName("_content")
    var content: String? = ""
): Parcelable
