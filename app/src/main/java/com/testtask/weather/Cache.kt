package com.testtask.weather

import com.testtask.weather.api.FiveDayWeatherJSON

class Cache {

    lateinit var weatherInfoCache:FiveDayWeatherJSON

    fun isThereCache(): Boolean{ return this::weatherInfoCache.isInitialized }
}