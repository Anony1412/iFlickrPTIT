package com.sunasterisk.iflickr.data.source.remote

import com.sunasterisk.iflickr.data.api.IFlickrApi
import com.sunasterisk.iflickr.data.source.PhotoDataSource

class PhotoRemoteDataSource(private val iFlickrApi: IFlickrApi) : PhotoDataSource.Remote {

    override fun getPublicPhotos(userId: String) = iFlickrApi.getPublicPhotos(userId)

    override fun getFavoritePersons(photoId: String) = iFlickrApi.getFavoritePersons(photoId)

    override fun getPhotoComments(photoId: String) = iFlickrApi.getPhotoComments(photoId)

    override fun getPhotoSets(userId: String) = iFlickrApi.getPhotoSets(userId)

    override fun getPhotoSetPhotos(
        userId: String,
        photoSetId: String
    ) = iFlickrApi.getPhotoSetPhotos(userId, photoSetId)
}
