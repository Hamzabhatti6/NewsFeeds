package com.hamza.bhatti.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.liveData
import com.hamza.bhatti.networks.Resource
import com.hamza.bhatti.repo.Repository
import kotlinx.coroutines.Dispatchers

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: Repository = Repository(application.applicationContext)

    fun getNews(section: String, period: String, apiKey: String) = liveData(Dispatchers.IO) {
        emit(Resource.loading(response = null))
        try {
            emit(Resource.success(response = repository.callGetNews(section,period,apiKey)))
        } catch (exception: Exception) {
            emit(Resource.error(response = null, message = exception.message ?: "Error Occurred!"))
        }
    }
}