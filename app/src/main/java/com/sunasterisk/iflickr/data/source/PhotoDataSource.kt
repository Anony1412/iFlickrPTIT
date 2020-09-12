package com.sunasterisk.iflickr.data.source

import com.sunasterisk.iflickr.data.source.remote.response.*
import io.reactivex.Observable
import io.reactivex.Single

interface PhotoDataSource {

    interface Local {

    }

    interface Remote {
        fun getPublicPhotos(userId: String): Single<PublicPhotosResponse>
        fun getFavoritePersons(photoId: String): Single<PhotoFavoritePersonsResponse>
        fun getPhotoComments(photoId: String): Single<PhotoCommentsResponse>
        fun getPhotoSets(userId: String): Observable<PhotoSetsResponse>
        fun getPhotoSetPhotos(
            userId: String,
            photoSetId: String
        ): Observable<PhotoSetPhotosResponse>
    }
}
