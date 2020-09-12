package com.sunasterisk.iflickr.data.source.remote

import com.sunasterisk.iflickr.data.api.IFlickrApi
import com.sunasterisk.iflickr.data.source.UserDataSource

class UserRemoteDataSource(private val iFlickrApi: IFlickrApi) : UserDataSource.Remote {

    override fun findUserByUsername(username: String) = iFlickrApi.findUserByUsername(username)

    override fun getUserProfile(userId: String) = iFlickrApi.getUserProfile(userId)
}
