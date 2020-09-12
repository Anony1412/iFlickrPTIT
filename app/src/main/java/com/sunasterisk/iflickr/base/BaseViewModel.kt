package com.sunasterisk.iflickr.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class BaseViewModel: ViewModel() {

    val messageErrorLiveData = MutableLiveData<String>()
}
