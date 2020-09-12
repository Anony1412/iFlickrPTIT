package com.sunasterisk.iflickr.utils

import com.sunasterisk.iflickr.data.api.ApiConstants
import com.sunasterisk.iflickr.data.api.ApiMethod

object Request {

    private const val BASE_URL =
        ApiConstants.PATH_SERVICE + "/" + ApiConstants.PATH_REST + "/" +
                "?" + ApiConstants.QUERY_METHOD + "="

    const val URL_FIND_USER_BY_USER_NAME =
        BASE_URL + ApiMethod.METHOD_FIND_USER_BY_USER_NAME

    const val URL_GET_USER_PROFILE =
        BASE_URL + ApiMethod.METHOD_GET_USER_PROFILE

    const val URL_GET_PUBLIC_PHOTO =
        BASE_URL + ApiMethod.METHOD_GET_PUBLIC_PHOTOS

    const val URL_GET_PHOTO_FAVORITE_PERSONS =
        BASE_URL + ApiMethod.METHOD_GET_PHOTO_FAVORITE_PERSONS

    const val URL_GET_PHOTO_COMMENTS =
        BASE_URL + ApiMethod.METHOD_GET_PHOTO_COMMENTS

    const val URL_GET_PHOTOSETS =
        BASE_URL + ApiMethod.METHOD_GET_PHOTOSETS

    const val URL_GET_PHOTO_OF_PHOTOSET =
        BASE_URL + ApiMethod.METHOD_GET_PHOTO_OF_PHOTOSET
}
