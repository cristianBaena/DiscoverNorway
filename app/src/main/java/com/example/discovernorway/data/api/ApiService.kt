package com.example.discovernorway.data.api

import com.example.discovernorway.PointsInt
import retrofit2.http.GET

interface ApiService {

    @GET("POIS")
    suspend fun getPois(): List<PointsInt>
}