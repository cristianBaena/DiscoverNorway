package com.example.discovernorway.data.model

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModel
import com.example.discovernorway.data.api.ApiHelper
import com.example.discovernorway.data.repository.MainRepository
import com.example.discovernorway.data.model.MainViewModel

class ViewModelFactory(private val apiHelper: ApiHelper): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(MainRepository(apiHelper)) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }

}