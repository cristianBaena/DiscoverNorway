package com.example.discovernorway.data.api



class ApiHelper(private val apiService: ApiService) {

    suspend fun getPois() = apiService.getPois()
}