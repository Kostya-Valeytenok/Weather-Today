package com.testtask.weather.ui.forecast

class ForecastItem {

    var dayOfWeek:String = ""
    lateinit var imageWeatherCode:String
    lateinit var time:String
    lateinit var typeOfWeather:String
    var temperature: Int = 0

    constructor(dayOfWeek: String) {
        this.dayOfWeek = dayOfWeek
    }

    constructor(imageWeatherCode: String, time: String, typeOfWeather: String, temperature: Int) {
        this.imageWeatherCode = imageWeatherCode
        this.time = time
        this.typeOfWeather = typeOfWeather
        this.temperature = temperature
    }

}