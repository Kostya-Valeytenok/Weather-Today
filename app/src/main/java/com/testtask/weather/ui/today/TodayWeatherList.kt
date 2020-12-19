package com.testtask.weather.ui.today

import android.annotation.SuppressLint
import com.testtask.weather.Cache
import com.testtask.weather.api.FiveDayWeatherJSON
import com.testtask.weather.api.body_of_json.Lists
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class TodayWeatherList {

    fun getTodayWeatherInfo(weatherInfo: FiveDayWeatherJSON): Observable<FiveDayWeatherJSON> {
        return Observable.create {
            subscriber ->
            subscriber.onNext(createTodayWeatherList(weatherInfo))
            subscriber.onComplete()
        }
    }

   private fun createTodayWeatherList( weatherInfo: FiveDayWeatherJSON) :FiveDayWeatherJSON{
        var todayWeatherJSON = FiveDayWeatherJSON()
        todayWeatherJSON.city =weatherInfo.city
        todayWeatherJSON.cod = weatherInfo.cod
        todayWeatherJSON.message = weatherInfo.message
        todayWeatherJSON.cnt = weatherInfo.cnt
        getTodayWeatherItemCount(weatherInfo).subscribe(getObserver(todayWeatherJSON,weatherInfo))
        return todayWeatherJSON
    }

    private fun getTodayWeatherItemCount(weatherInfo: FiveDayWeatherJSON): Observable<Int> {
        return Observable.create {
            subscriber ->
            subscriber.onNext(getItemCount(weatherInfo))
            subscriber.onComplete()
        }
    }
    @SuppressLint("SimpleDateFormat")
    private fun getItemCount(weatherInfo: FiveDayWeatherJSON):Int{
        var itemCount = -1;
        var dateIsoUtsFormat = weatherInfo.list[0].dt_txt
        val dateFormat: Date = SimpleDateFormat("y-M-d H:m:s").parse(dateIsoUtsFormat)!!
        val temp =dateFormat.day
        var isItToday = true
         var x = 0
        while (isItToday){
            var currentDateIsoUtsFormat = weatherInfo.list[x].dt_txt
            val currentDateFormat: Date = SimpleDateFormat("y-M-d H:m:s").parse(currentDateIsoUtsFormat)!!
            if(temp != currentDateFormat.day) {
                isItToday = false
            }
            x++
            itemCount++
        }
        return itemCount
    }
    private fun getObserver(todayWeatherJSON:FiveDayWeatherJSON, weatherInfo: FiveDayWeatherJSON): Observer<Int> {
        return object : Observer<Int> {
            override fun onNext(t: Int?) {
                System.out.println("t: "+t)
                var todayWeatherList:ArrayList<Lists> = ArrayList()
                for (x in 0 until t!!) todayWeatherList.add(weatherInfo.list[x])
                todayWeatherJSON.list =todayWeatherList
            }
            override fun onError(e: Throwable?) {}
            override fun onComplete() {}
            override fun onSubscribe(d: Disposable?) {}
        }
    }
}