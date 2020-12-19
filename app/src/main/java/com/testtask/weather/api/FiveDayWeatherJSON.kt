package com.testtask.weather.api

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.testtask.weather.api.body_of_json.City
import com.testtask.weather.api.body_of_json.Lists

class FiveDayWeatherJSON {

    @SerializedName("cod")
    @Expose
    lateinit var cod: String
    @SerializedName("message")
    @Expose
    lateinit var message: String
    @SerializedName("cnt")
    @Expose
    lateinit var cnt: String
    @SerializedName("list")
    @Expose
    lateinit var list:List<Lists>
    @SerializedName("city")
    @Expose
    lateinit var city: City
}