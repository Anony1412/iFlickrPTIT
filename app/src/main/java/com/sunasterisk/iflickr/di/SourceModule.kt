package com.sunasterisk.iflickr.di

import com.sunasterisk.iflickr.data.repository.PhotoRepository
import com.sunasterisk.iflickr.data.repository.UserRepository
import com.sunasterisk.iflickr.data.source.local.PhotoLocalDataSource
import com.sunasterisk.iflickr.data.source.local.UserLocalDataSource
import com.sunasterisk.iflickr.data.source.remote.PhotoRemoteDataSource
import com.sunasterisk.iflickr.data.source.remote.UserRemoteDataSource
import org.koin.core.qualifier.named
import org.koin.dsl.module

val sourceModule = module {

    single(named(KoinNames.USER_REPOSITORY)) {
        UserRepository(
            get(named(KoinNames.USER_LOCAL_DATASOURCE)),
            get(named(KoinNames.USER_REMOTE_DATASOURCE))
        )
    }

    single(named(KoinNames.PHOTO_REPOSITORY)) {
        PhotoRepository(
            get(named(KoinNames.PHOTO_LOCAL_DATASOURCE)),
            get(named(KoinNames.PHOTO_REMOTE_DATASOURCE))
        )
    }

    single(named(KoinNames.USER_REMOTE_DATASOURCE)) {
        UserRemoteDataSource(get(named(KoinNames.FLICKR_API)))
    }

    single(named(KoinNames.USER_LOCAL_DATASOURCE)) {
        UserLocalDataSource()
    }

    single(named(KoinNames.PHOTO_REMOTE_DATASOURCE)) {
        PhotoRemoteDataSource(get(named(KoinNames.FLICKR_API)))
    }

    single(named(KoinNames.PHOTO_LOCAL_DATASOURCE)) {
        PhotoLocalDataSource()
    }
}
