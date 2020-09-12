package com.sunasterisk.iflickr.data.api

import com.sunasterisk.iflickr.data.source.remote.response.*
import com.sunasterisk.iflickr.utils.Request
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface IFlickrApi {

    @GET(Request.URL_FIND_USER_BY_USER_NAME)
    fun findUserByUsername(
        @Query(ApiConstants.QUERY_USERNAME) username: String
    ): Single<UserResponse>

    @GET(Request.URL_GET_USER_PROFILE)
    fun getUserProfile(
        @Query(ApiConstants.QUERY_USER_ID) userId: String
    ): Single<UserProfileResponse>

    @GET(Request.URL_GET_PUBLIC_PHOTO)
    fun getPublicPhotos(
        @Query(ApiConstants.QUERY_USER_ID) userId: String
    ): Single<PublicPhotosResponse>

    @GET(Request.URL_GET_PHOTO_FAVORITE_PERSONS)
    fun getFavoritePersons(
        @Query(ApiConstants.QUERY_PHOTO_ID) photoId: String
    ): Single<PhotoFavoritePersonsResponse>

    @GET(Request.URL_GET_PHOTO_COMMENTS)
    fun getPhotoComments(
        @Query(ApiConstants.QUERY_PHOTO_ID) photoId: String
    ): Single<PhotoCommentsResponse>

    @GET(Request.URL_GET_PHOTOSETS)
    fun getPhotoSets(
        @Query(ApiConstants.QUERY_USER_ID) userId: String
    ): Observable<PhotoSetsResponse>

    @GET(Request.URL_GET_PHOTO_OF_PHOTOSET)
    fun getPhotoSetPhotos(
        @Query(ApiConstants.QUERY_USER_ID) userId: String,
        @Query(ApiConstants.QUERY_PHOTOSET_ID) photoSetId: String
    ): Observable<PhotoSetPhotosResponse>
}
