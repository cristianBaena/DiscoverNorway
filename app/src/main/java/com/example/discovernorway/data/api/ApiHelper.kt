package com.example.discovernorway.data.api

import com.example.discovernorway.data.api.RetrofitBuilder.apiService

class ApiHelper(private val apiService: ApiService) {

    suspend fun getPois() = apiService.getPois()
}