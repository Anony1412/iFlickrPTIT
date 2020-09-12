package com.sunasterisk.iflickr.data.model

import android.os.Parcelable
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.sunasterisk.iflickr.data.model.User.Companion.TABLE_NAME
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = TABLE_NAME)
data class User (

    @PrimaryKey(autoGenerate = true)
    var userId: Int? = null,

    @SerializedName(NSID)
    var nsId: String? = "",

    @SerializedName(USER_NAME)
    @Embedded
    var username: Username? = null,

    @SerializedName(FIRST_NAME)
    var firstName: String? = "",

    @SerializedName(LAST_NAME)
    var lastName: String? = "",

    @SerializedName(PROFILE_DESCRIPTION)
    var profileDescription: String? = "",

    @SerializedName(HOMETOWN)
    var hometown: String? = "",

    @SerializedName(CITY)
    var city: String? = "",

    @SerializedName(COUNTRY)
    var country: String? = "",

    @Ignore
    @SerializedName(PUBLIC_PHOTOS)
    var publicPhotos: Photos? = null
): Parcelable {

    companion object {
        const val TABLE_NAME = "tbl_user"
        const val NSID = "nsid"
        const val USER_NAME = "username"
        const val FIRST_NAME = "first_name"
        const val LAST_NAME = "last_name"
        const val PROFILE_DESCRIPTION = "profile_description"
        const val PUBLIC_PHOTOS = "photos"
        const val HOMETOWN = "hometown"
        const val CITY = "city"
        const val COUNTRY = "country"
    }
}
