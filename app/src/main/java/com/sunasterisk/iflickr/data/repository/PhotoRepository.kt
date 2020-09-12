package com.sunasterisk.iflickr.data.repository

import com.sunasterisk.iflickr.data.source.PhotoDataSource
import com.sunasterisk.iflickr.data.source.remote.response.*
import io.reactivex.Observable
import io.reactivex.Single

class PhotoRepository (
    private val localDataSource: PhotoDataSource.Local,
    private val remoteDataSource: PhotoDataSource.Remote
) {

    fun getPublicPhotos(userId: String): Single<PublicPhotosResponse> =
        remoteDataSource.getPublicPhotos(userId)

    fun getFavoritePersons(photoId: String): Single<PhotoFavoritePersonsResponse> =
        remoteDataSource.getFavoritePersons(photoId)

    fun getPhotoComments(photoId: String): Single<PhotoCommentsResponse> =
        remoteDataSource.getPhotoComments(photoId)

    fun getPhotoSets(userId: String): Observable<PhotoSetsResponse> =
        remoteDataSource.getPhotoSets(userId)

    fun getPhotoSetPhotos(userId: String, photoSetId: String): Observable<PhotoSetPhotosResponse> =
        remoteDataSource.getPhotoSetPhotos(userId, photoSetId)
}
