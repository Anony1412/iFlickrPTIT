package com.sunasterisk.iflickr.data.source.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sunasterisk.iflickr.data.model.Photo
import com.sunasterisk.iflickr.data.model.User
import com.sunasterisk.iflickr.data.source.local.dao.PhotoDao
import com.sunasterisk.iflickr.data.source.local.dao.UserDao
import com.sunasterisk.iflickr.utils.DatabaseConstants

@Database(entities = [User::class, Photo::class], version = DatabaseConstants.DB_VERSION)
abstract class IFlickrDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

    abstract fun photoDao(): PhotoDao
}
