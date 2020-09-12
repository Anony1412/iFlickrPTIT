package com.sunasterisk.iflickr.ui.fragment.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sunasterisk.iflickr.base.BaseViewModel
import com.sunasterisk.iflickr.data.repository.PhotoRepository
import com.sunasterisk.iflickr.data.repository.UserRepository
import com.sunasterisk.iflickr.data.source.remote.response.PublicPhotosResponse
import com.sunasterisk.iflickr.data.source.remote.response.UserProfileResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers

class ProfileViewModel(
    private val userRepository: UserRepository,
    private val photoRepository: PhotoRepository
) : BaseViewModel() {

    val disposable = CompositeDisposable()

    val userProfileResponse: LiveData<UserProfileResponse> get() = _userProfileResponse
    private var _userProfileResponse = MutableLiveData<UserProfileResponse>()

    val publicPhotosResponse: LiveData<PublicPhotosResponse> get() =  _publicPhotosResponse
    private var _publicPhotosResponse = MutableLiveData<PublicPhotosResponse>()

    fun getUserProfile(userId: String) {
        userRepository.getUserProfile(userId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { _userProfileResponse.value = it },
                { messageErrorLiveData.value = it.message }
            ).addTo(disposable)
    }

    fun getPublicPhotos(userId: String) {
        photoRepository.getPublicPhotos(userId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { _publicPhotosResponse.value = it },
                { messageErrorLiveData.value = it.message }
            ).addTo(disposable)
    }


}
