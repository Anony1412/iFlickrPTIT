package com.sunasterisk.iflickr.data.repository

import com.sunasterisk.iflickr.data.model.User
import com.sunasterisk.iflickr.data.source.UserDataSource
import com.sunasterisk.iflickr.data.source.remote.response.UserProfileResponse
import com.sunasterisk.iflickr.data.source.remote.response.UserResponse
import io.reactivex.Single

class UserRepository (
    private val localDataSource: UserDataSource.Local,
    private val remoteDataSource: UserDataSource.Remote
) {

    fun findUserByUsername(username: String): Single<UserResponse> =
        remoteDataSource.findUserByUsername(username)

    fun getUserProfile(userId: String): Single<UserProfileResponse> =
        remoteDataSource.getUserProfile(userId)

    fun getAllUserFollows(): Single<List<User>> = localDataSource.getAllUsers()
}
