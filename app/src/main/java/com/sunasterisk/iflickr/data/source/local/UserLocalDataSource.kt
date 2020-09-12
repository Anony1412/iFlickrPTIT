package com.sunasterisk.iflickr.data.source.local

import com.sunasterisk.iflickr.data.model.User
import com.sunasterisk.iflickr.data.source.UserDataSource
import com.sunasterisk.iflickr.data.source.local.database.IFlickrDatabase
import io.reactivex.Single

class UserLocalDataSource(
    private val iFlickrDatabase: IFlickrDatabase
): UserDataSource.Local {

    override fun getAllUsers(): Single<List<User>> = iFlickrDatabase.userDao().getAllUsers()
}
