package com.sunasterisk.iflickr.di

import com.sunasterisk.iflickr.data.api.ApiConstants
import com.sunasterisk.iflickr.data.api.ApiFactory
import com.sunasterisk.iflickr.data.api.IFlickrApi
import io.reactivex.schedulers.Schedulers
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

val apiModule = module {

    single(named(KoinNames.FLICKR_API)) {
        ApiFactory.buildApi(
            baseUrl = ApiConstants.BASE_URL,
            restApi = IFlickrApi::class.java,
            client = get(named(KoinNames.CLIENT)),
            converterFactory = get(named(KoinNames.GSON_CONVERTER_FACTORY)),
            callAdapterFactory = get(named(KoinNames.RX_JAVA_2_CALL_ADAPTER_FACTORY))
        )
    }

    single(named(KoinNames.CLIENT)) {
        ApiFactory.buildClient()
    }

    single(named(KoinNames.GSON_CONVERTER_FACTORY)) {
        GsonConverterFactory.create()
    }

    single(named(KoinNames.RX_JAVA_2_CALL_ADAPTER_FACTORY)) {
        RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io())
    }
}
