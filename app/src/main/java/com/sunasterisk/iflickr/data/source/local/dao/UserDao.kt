package com.sunasterisk.iflickr.data.source.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.sunasterisk.iflickr.data.model.User
import com.sunasterisk.iflickr.utils.DatabaseConstants
import io.reactivex.Completable
import io.reactivex.Single

@Dao
interface UserDao {

    @Query(DatabaseConstants.QUERY_GET_ALL_USERS)
    fun getAllUsers(): Single<List<User>>

    @Insert
    fun insertUser(user: User): Completable

    @Delete
    fun deletedUser(user: User): Completable
}
