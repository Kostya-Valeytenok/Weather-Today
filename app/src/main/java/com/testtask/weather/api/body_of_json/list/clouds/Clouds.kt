package com.testtask.weather.api.body_of_json.list.clouds

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Clouds {
    @SerializedName("all")
    @Expose
    lateinit var all: String
}