package com.sunasterisk.iflickr.di

object KoinNames {

    // api
    const val FLICKR_API = "com.sunasterisk.iflickr.di.FLICKR_API"
    const val GSON_CONVERTER_FACTORY = "com.sunasterisk.iflickr.di.GSON_CONVERTER_FACTORY"
    const val RX_JAVA_2_CALL_ADAPTER_FACTORY = 
        "com.sunasterisk.iflickr.di.RX_JAVA_2_CALL_ADAPTER_FACTORY"
    const val CLIENT = "com.sunasterisk.iflickr.di.CLIENT"

    // datasource
    const val USER_REMOTE_DATASOURCE = "com.sunasterisk.iflickr.di.USER_REMOTE_DATASOURCE"
    const val USER_LOCAL_DATASOURCE = "com.sunasterisk.iflickr.di.USER_LOCAL_DATASOURCE"
    const val PHOTO_REMOTE_DATASOURCE = "com.sunasterisk.iflickr.di.PHOTO_REMOTE_DATASOURCE"
    const val PHOTO_LOCAL_DATASOURCE = "com.sunasterisk.iflickr.di.PHOTO_LOCAL_DATASOURCE"

    // reposiroty
    const val USER_REPOSITORY = "com.sunasterisk.iflickr.di.USER_REPOSITORY"
    const val PHOTO_REPOSITORY = "com.sunasterisk.iflickr.di.PHOTO_REPOSITORY"
}
