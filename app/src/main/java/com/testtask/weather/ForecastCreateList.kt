package com.testtask.weather

import android.app.Activity
import com.testtask.weather.di.GetDIApplication
import com.testtask.weather.di.forecast_list.DaggerForecastListComponent
import com.testtask.weather.ui.forecast.ForecastItem
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class ForecastCreateList(act:Activity) {
    val forecastList: ArrayList<ForecastItem> = ArrayList()
    var dayOfWeak = arrayOf("SUNDAY","MONDAY","TUESDAY","WEDNESDAY","THURSDAY","FRIDAY","SATURDAY")
    var temp = 0
    val forecastComponent= DaggerForecastListComponent.builder().cacheComponents(GetDIApplication().get(act)?.getCache()).build()


    init {
        var dateIsoUtsFormat = forecastComponent.getCache.weatherInfoCache.list[0].dt_txt
        val dateFormat: Date = SimpleDateFormat("y-M-d H:m:s").parse(dateIsoUtsFormat)
        temp =dateFormat.day
        forecastList.add(ForecastItem("Today"))
        var x = 0
        while (x<forecastComponent.getCache.weatherInfoCache.list.size){
            var currentDateIsoUtsFormat = forecastComponent.getCache.weatherInfoCache.list[x].dt_txt
            val currentDateFormat: Date = SimpleDateFormat("y-M-d H:m:s").parse(currentDateIsoUtsFormat)
            var temp1 =currentDateFormat.day
            if(temp != currentDateFormat.day) {
               println("Day: "+ currentDateFormat.day)
                forecastList.add(ForecastItem(dayOfWeak[(currentDateFormat.day)]))
                temp =currentDateFormat.day
                x-=1
            }
            else{
                forecastList.add(ForecastItem(forecastComponent.getCache.weatherInfoCache.list[x].weather[0].icon,
                        setVal(currentDateFormat.hours, currentDateFormat.minutes),
                        forecastComponent.getCache.weatherInfoCache.list[x].weather[0].description.capitalize(),
                    forecastComponent.getCache.weatherInfoCache.list[x].main.temp.toInt() - 273))
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