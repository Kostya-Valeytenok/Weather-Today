package com.testtask.weather.api.body_of_json

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.testtask.weather.api.body_of_json.list.wind.Wind
import com.testtask.weather.api.body_of_json.list.clouds.Clouds
import com.testtask.weather.api.body_of_json.list.main.Main
import com.testtask.weather.api.body_of_json.list.pod.Pod
import com.testtask.weather.api.body_of_json.list.rain.Rain
import com.testtask.weather.api.body_of_json.list.snow.Snow
import com.testtask.weather.api.body_of_json.list.weather.Weather
import kotlin.coroutines.coroutineContext

class Lists {
    @SerializedName("dt")
    @Expose
    lateinit var dt: String
    @SerializedName("main")
    @Expose
    lateinit var main: Main
    @SerializedName("weather")
    @Expose
    lateinit var weather: List<Weather>
    @SerializedName("clouds")
    @Expose
    lateinit var clouds: Clouds
    @SerializedName("wind")
    @Expose
    lateinit var wind: Wind
    @SerializedName("visibility")
    @Expose
    lateinit var visibility: String
    @SerializedName("pop")
    @Expose
    lateinit var pop: String
    @SerializedName("rain")
    @Expose
    lateinit var rain: Rain
    @SerializedName("snow")
    @Expose
    lateinit var snow: Snow
    @SerializedName("sys")
    @Expose
    lateinit var sys: Pod
    @SerializedName("dt_txt")
    @Expose
    lateinit var dt_txt: String

    fun getRainFallValue():Double{
        var rainFallCount = 0.0
        if(this::rain.isInitialized)
            rainFallCount += rain.h3
        if(this::snow.isInitialized)
            rainFallCount += snow.h3
        return rainFallCount
    }
}