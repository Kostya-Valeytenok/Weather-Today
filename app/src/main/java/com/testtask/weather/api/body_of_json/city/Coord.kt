package com.testtask.weather.api.body_of_json.city

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Coord {
    @SerializedName("lat")
    @Expose
    lateinit var lat: String
    @SerializedName("lon")
    @Expose
    lateinit var lon: String
}