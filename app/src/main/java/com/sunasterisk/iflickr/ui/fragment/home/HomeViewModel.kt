package com.sunasterisk.iflickr.ui.fragment.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sunasterisk.iflickr.base.BaseViewModel
import com.sunasterisk.iflickr.data.repository.PhotoRepository
import com.sunasterisk.iflickr.data.source.remote.response.PhotoSetPhotosResponse
import com.sunasterisk.iflickr.data.source.remote.response.PhotoSetsResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers

class HomeViewModel(private val photoRepository: PhotoRepository) : BaseViewModel() {

    val disposable = CompositeDisposable()

    val photoSetsResponse: LiveData<PhotoSetsResponse> get() = _photoSetsResponse
    private val _photoSetsResponse = MutableLiveData<PhotoSetsResponse>()

    val photoSetPhotosResponse: LiveData<PhotoSetPhotosResponse> get() = _photoSetPhotosResponse
    private val _photoSetPhotosResponse = MutableLiveData<PhotoSetPhotosResponse>()

    fun getPhotoSets(userId: String) {
        photoRepository.getPhotoSets(userId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    _photoSetsResponse.value = it
                    it.photosets?.photoSet?.forEach { photoSet ->
                        getPhotoSetPhotos(userId, photoSet.id)
                    }
                },
                { messageErrorLiveData.value = it.message }
            )
            .addTo(disposable)
    }

    private fun getPhotoSetPhotos(userId: String, photoSetId: String?) {
        photoSetId?.let {
            photoRepository.getPhotoSetPhotos(userId, photoSetId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    { _photoSetPhotosResponse.value = it },
                    { messageErrorLiveData.value = it.message }
                ).addTo(disposable)
        }
    }
}
