package com.codehub.metroapp.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class MvvmRepository {

    private val _streamData = MutableLiveData<String>("")

    val streamData: LiveData<String> = _streamData

    fun getNewApiData(data: String) {
        _streamData.postValue(data)
    }
}