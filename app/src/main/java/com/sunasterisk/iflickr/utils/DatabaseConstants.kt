package com.sunasterisk.iflickr.utils

import com.sunasterisk.iflickr.data.model.Photo
import com.sunasterisk.iflickr.data.model.User

object DatabaseConstants {

    const val DB_NAME = "iFlickr-database"
    const val DB_VERSION = 1

    const val QUERY_GET_ALL_USERS = "SELECT * FROM ${User.TABLE_NAME}"
    const val QUERY_GET_ALL_PHOTOS = "SELECT * FROM ${Photo.TABLE_NAME}"
}
