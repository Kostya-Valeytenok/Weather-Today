package com.testtask.weather.api.body_of_json.list.weather

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Weather {
    @SerializedName("id")
    @Expose
    lateinit var id: String
    @SerializedName("main")
    @Expose
    lateinit var main: String
    @SerializedName("description")
    @Expose
    lateinit var description: String
    @SerializedName("icon")
    @Expose
    lateinit var icon: String
}