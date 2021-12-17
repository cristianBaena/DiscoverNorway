package com.example.discovernorway.data.repository

import com.example.discovernorway.data.api.ApiHelper

class MainRepository(private val apiHelper: ApiHelper) {
    suspend fun getPois() = apiHelper.getPois()
}