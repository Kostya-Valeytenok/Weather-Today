package com.testtask.weather.api.body_of_json.list.main

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Main {

    @SerializedName("temp")
    @Expose
    var temp:Double = 0.0
    @SerializedName("feels_like")
    @Expose
    var feels_like:Double = 0.0
    @SerializedName("temp_min")
    @Expose
    var temp_min:Double = 0.0
    @SerializedName("temp_max")
    @Expose
    var temp_max:Double = 0.0
    @SerializedName("pressure")
    @Expose
    var pressure:Double = 0.0
    @SerializedName("sea_level")
    @Expose
    var sea_level:Double = 0.0
    @SerializedName("grnd_level")
    @Expose
    var grnd_level:Double = 0.0
    @SerializedName("humidity")
    @Expose
    var humidity:Double = 0.0
    @SerializedName("temp_kf")
    @Expose
    var temp_kf:Double = 0.0
}