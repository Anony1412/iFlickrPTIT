package com.sunasterisk.iflickr.di

import com.sunasterisk.iflickr.ui.fragment.home.HomeViewModel
import com.sunasterisk.iflickr.ui.fragment.profile.ProfileViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val viewModelModule = module {

    viewModel { HomeViewModel(get(named(KoinNames.PHOTO_REPOSITORY))) }

    viewModel {
        ProfileViewModel(
            get(named(KoinNames.USER_REPOSITORY)),
            get(named(KoinNames.PHOTO_REPOSITORY))
        )
    }
}
