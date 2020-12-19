package com.testtask.weather

import com.testtask.weather.ui.forecast.ForecastItem
import java.text.SimpleDateFormat
import java.time.Instant
import java.util.*
import kotlin.collections.ArrayList

class ForecastCreateList {
    val forecastList: ArrayList<ForecastItem> = ArrayList()
    var dayOfWeak = arrayOf("SUNDAY","MONDAY","TUESDAY","WEDNESDAY","THURSDAY","FRIDAY","SATURDAY")
    var temp = 0
    init {
        var dateIsoUtsFormat = Cache.INSTANCE.weatherInfoCache.list[0].dt_txt
        val dateFormat: Date = SimpleDateFormat("y-M-d H:m:s").parse(dateIsoUtsFormat)
        temp =dateFormat.day
        forecastList.add(ForecastItem("Today"))
        var x = 0
        while (x<Cache.INSTANCE.weatherInfoCache.list.size){
            var currentDateIsoUtsFormat = Cache.INSTANCE.weatherInfoCache.list[x].dt_txt
            val currentDateFormat: Date = SimpleDateFormat("y-M-d H:m:s").parse(currentDateIsoUtsFormat)
            var temp1 =currentDateFormat.day
            if(temp != currentDateFormat.day) {
               println("Day: "+ currentDateFormat.day)
                forecastList.add(ForecastItem(dayOfWeak[(currentDateFormat.day)]))
                temp =currentDateFormat.day
                x-=1
            }
            else{
                forecastList.add(ForecastItem(Cache.INSTANCE.weatherInfoCache.list[x].weather[0].icon,
                        setVal(currentDateFormat.hours, currentDateFormat.minutes),
                        Cache.INSTANCE.weatherInfoCache.list[x].weather[0].description.capitalize(),
                        Cache.INSTANCE.weatherInfoCache.list[x].main.temp.toInt() - 273))
            }
            x++
        }

    }
    fun setVal(hours:Int,minutes:Int):String{
        var h =""
        var m = ""
        if(hours<10) h="0"+hours
        else  h=""+hours
        if(minutes<10) m="0"+minutes
        else h =""+minutes
        return  ""+h+ ":" +m
    }
}