package com.example.discovernorway.data.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.discovernorway.PointsAdapter
import com.example.discovernorway.PointsInt
import kotlinx.coroutines.Dispatchers
import com.example.discovernorway.data.repository.MainRepository
import com.example.discovernorway.utils.Resource

class MainViewModel(private val mainRepository: MainRepository): ViewModel() {

    fun getPois() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = mainRepository.getPois()))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }

}