package com.sunasterisk.iflickr.data.model

import android.os.Parcelable
import com.sunasterisk.iflickr.utils.createAvatarUrl
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Post(
    var user: User? = null,
    var photoSet: PhotoSet? = null,
    var photos: List<Photo>? = null
): Parcelable {

    fun getUserAvatar(): String =
        String().createAvatarUrl(photoSet?.farm, photoSet?.server, "130158398@N07")

    fun getUsername() = photoSet?.username

    fun getPhotoSetTitle() = photoSet?.title?.content

}
