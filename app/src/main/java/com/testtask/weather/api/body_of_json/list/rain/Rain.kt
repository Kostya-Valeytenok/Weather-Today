package com.testtask.weather.api.body_of_json.list.rain

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Rain {

    @SerializedName("3h")
    @Expose
    var h3: Double = 0.0
}