package com.testtask.weather.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface JSONPlaceHolderApi {
    @GET("/data/2.5/forecast?")
    fun getInfo(@Query("lat") lat: Double?, @Query("lon") lon: Double?, @Query("APPID") API_key: String?): Call<FiveDayWeatherJSON>
}