package com.sunasterisk.iflickr.data.source

import com.sunasterisk.iflickr.data.model.User
import com.sunasterisk.iflickr.data.source.remote.response.UserProfileResponse
import com.sunasterisk.iflickr.data.source.remote.response.UserResponse
import io.reactivex.Single

interface UserDataSource {

    interface Local {
        fun getAllUsers(): Single<List<User>>
    }

    interface Remote {
        fun findUserByUsername(username: String): Single<UserResponse>
        fun getUserProfile(userId: String): Single<UserProfileResponse>
    }
}
