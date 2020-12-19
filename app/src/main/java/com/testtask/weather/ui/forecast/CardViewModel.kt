package com.testtask.weather.ui.forecast

import android.app.Activity
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import androidx.databinding.BaseObservable
import com.squareup.picasso.Picasso
import com.testtask.weather.R
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import kotlin.collections.ArrayList

class CardViewModel(var lists:ArrayList<ForecastItem>, var activity: Activity) :BaseObservable() {

    var weatherIcon: Drawable
    var time: String = "00:00"
    var weatherType:String =""
    var temperature:String =""

    init {
        weatherIcon = activity.resources.getDrawable(R.drawable.temp_ic)
    }

    fun setDate(position:Int){
        time = lists[position].time
        weatherType = lists[position].typeOfWeather
        temperature = lists[position].temperature.toString()+"°"
        notifyChange()
        val t = Thread(Runnable {  weatherIcon = BitmapDrawable(activity.resources,
            Picasso.with(activity).load(createUrlFromMessage(lists[position].imageWeatherCode)).get())
            notifyChange()})
        t.start()
    }
    fun createUrlFromMessage(mes:String):String{
        var firstPart = "http://openweathermap.org/img/wn/"
        var lastPart = "@2x.png"
        var message = firstPart+mes + lastPart
        return message
    }
}