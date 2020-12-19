package com.testtask.weather.api.body_of_json

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.testtask.weather.api.body_of_json.city.Coord

class City {
    @SerializedName("id")
    @Expose
    lateinit var id: String
    @SerializedName("name")
    @Expose
    lateinit var name: String
    @SerializedName("coord")
    @Expose
    lateinit var coourd: Coord
    @SerializedName("country")
    @Expose
    lateinit var country: String
    @SerializedName("timezone")
    @Expose
    lateinit var timezone: String
    @SerializedName("sunrise")
    @Expose
    lateinit var sunrise: String
    @SerializedName("sunset")
    @Expose
    lateinit var sunset: String
}