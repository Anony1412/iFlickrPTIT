package com.sunasterisk.iflickr.data.source.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.sunasterisk.iflickr.data.model.Photo
import com.sunasterisk.iflickr.utils.DatabaseConstants
import io.reactivex.Completable
import io.reactivex.Single

@Dao
interface PhotoDao {

    @Query(DatabaseConstants.QUERY_GET_ALL_PHOTOS)
    fun getAllPhotos(): Single<List<Photo>>

    @Insert
    fun insertPhoto(photo: Photo): Completable

    @Delete
    fun deletePhoto(photo: Photo): Completable
}
