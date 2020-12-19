package com.testtask.weather.api.body_of_json.list.wind

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Wind {
    @SerializedName("speed")
    @Expose
    lateinit var speed: String
    @SerializedName("deg")
    @Expose
    lateinit var deg: String
}