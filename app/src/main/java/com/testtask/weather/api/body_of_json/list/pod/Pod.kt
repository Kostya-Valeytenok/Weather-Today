package com.testtask.weather.api.body_of_json.list.pod

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Pod {
    @SerializedName("pod")
    @Expose
    lateinit var pod: String
}