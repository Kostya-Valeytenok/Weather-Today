package com.testtask.weather.api.body_of_json.list.snow

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Snow {
    @SerializedName("3h")
    @Expose
    var h3: Double = 0.0
}