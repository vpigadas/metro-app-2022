package com.codehub.metroapp.mvvm

import android.app.Application
import android.content.Context
import androidx.lifecycle.*
import com.codehub.metroapp.R
import com.codehub.metroapp.database.MyDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MvvmViewModel : ViewModel() {

    private val repository: MvvmRepository = MvvmRepository()
    private val apiManager: ApiManager = ApiManager()
    private lateinit var database: MyDatabase

    fun retrieveApiData(context: Context) {
        viewModelScope.launch(Dispatchers.Default) {
            if (database.hasData()) {
                database.getUserDao().getAll()
            } else {
                apiManager.makeACall(context, object : ApiManager.OnResult {
                    override fun onSuccess(data: String) {
                        viewModelScope.launch(Dispatchers.Main) { repository.getNewApiData(data) }
                    }

                    override fun onFailed(error: Exception) {
                        TODO("Not yet implemented")
                    }
                })
            }
        }
    }

    fun observeData(owner: LifecycleOwner, observer: Observer<String>) {
        repository.streamData.observe(owner, observer)
    }

    override fun onCleared() {
        super.onCleared()
    }
}

class AndroidMvvmViewModel(application: Application) : AndroidViewModel(application) {

    fun demo() {
        getApplication<Application>().getString(R.string.app_name)
    }
}

