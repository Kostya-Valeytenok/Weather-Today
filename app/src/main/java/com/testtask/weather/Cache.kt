package com.testtask.weather

import com.testtask.weather.api.FiveDayWeatherJSON

class Cache private constructor() {

    lateinit var weatherInfoCache:FiveDayWeatherJSON
    private object HOLDER { val INSTANCE = Cache() }

    companion object { val INSTANCE: Cache by lazy { HOLDER.INSTANCE } }

    fun isThereCache(): Boolean{ return this::weatherInfoCache.isInitialized }

}