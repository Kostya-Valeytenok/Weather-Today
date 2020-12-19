package com.testtask.weather.ui.today

import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Intent
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.widget.Toast
import androidx.appcompat.content.res.AppCompatResources.getDrawable
import androidx.databinding.BaseObservable
import com.squareup.picasso.Picasso
import com.testtask.weather.BR
import com.testtask.weather.R
import com.testtask.weather.ViewPagerAdapter
import com.testtask.weather.api.FiveDayWeatherJSON
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class ViewPagerViewModel(var context: Activity, var weatherInfo: FiveDayWeatherJSON) : BaseObservable() {

    var dayOfWeak = arrayOf("SUNDAY","MONDAY","TUESDAY","WEDNESDAY","THURSDAY","FRIDAY","SATURDAY")
    var centrPartOfTem =" | "
    var temperature = "0°C | Cloudy"
    var feelsLike =""
    var humidity ="0%"
    var clouds: String = "London, UK"
    var atmosphericPressure ="1000 hPA"
    var windSpeed = "20 km/h"
    var windDirection = "N"
    var testMessage: String = "10d"
    var place:String
    var ic :Drawable
    var rainFall = "0.0 mm"
    var date = ""
    var weatherType =""

    init {
        ic = getDrawable(context,R.drawable.temp_ic)!!
        place=""
    }

    fun setWeatherInfo(position:Int){
        weatherType =weatherInfo.list[position].weather[0].description.capitalize()
        temperature = "" +(Math.floor(weatherInfo.list[position].main.temp) -273.0).toInt()+"°C"+ centrPartOfTem + weatherInfo.list[position].weather[0].description.capitalize()
        feelsLike = context.getString(R.string.feels_like) + ((Math.floor(weatherInfo.list[position].main.feels_like)).toInt()-273) +"°C"
        humidity = "" + (Math.floor(weatherInfo.list[position].main.humidity)).toInt() +"%"
        clouds  = weatherInfo.list[position].clouds.all +"%"
        atmosphericPressure = ""+ (Math.floor(weatherInfo.list[position].main.pressure)).toInt() + " hPA"
        windSpeed = weatherInfo.list[position].wind.speed + " km/h"
        windDirection = getWindDirection(position)
        getPhotoDrawableForUrl(position)
        place = weatherInfo.city.name +", "+weatherInfo.city.country
        rainFall= ""+ weatherInfo.list[position].getRainFallValue() + " mm"
        var dateIsoUtsFormat = weatherInfo.list[position].dt_txt
        getTime(dateIsoUtsFormat,position)
    }

    private fun getWindDirection(position: Int):String{
        return createDirectionFromPair(position,setDirectionsPair(position))
    }
    private fun createDirectionFromPair(position: Int, directionPain:ArrayList<String>):String{
        var direction = ""
        var windValue =weatherInfo.list[position].wind.deg.toInt()
        while (windValue>90)
            windValue-=90
        if(windValue<=30)
            direction= directionPain[0]
        if(windValue in 31..59)
            direction= directionPain[0]+directionPain[1]
        if(windValue <=90)
            direction= directionPain[1]
        return direction
    }
    private fun setDirectionsPair(position: Int):ArrayList<String>{
        var directionsList = ArrayList<String>(2)
        var windValue =weatherInfo.list[position].wind.deg.toInt()
        if(windValue<=90){
            directionsList.add("N")
            directionsList.add("E")
        }
        else if(windValue>90 &&windValue<=180){
            directionsList.add("E")
            directionsList.add("S")
        }
        else if(windValue>180 &&windValue<=270){
            directionsList.add("S")
            directionsList.add("W")
        }
        else if(windValue>270 &&windValue<=360){
            directionsList.add("W")
            directionsList.add("N")
        }
        return directionsList
    }

    fun getPhotoDrawableForUrl(position: Int){
        var tread = Thread(Runnable { ic = BitmapDrawable(context.resources,
                Picasso.with(context).
                load(createUrlFromMessage(weatherInfo.list[position].weather[0].icon)).get())
            notifyPropertyChanged(BR._all)})
        tread.start()
    }
    fun createUrlFromMessage(mes:String):String{
        var firstPart = "http://openweathermap.org/img/wn/"
        var lastPart = "@2x.png"
        var message = firstPart+mes + lastPart
        return message
    }

    private fun getTime(dateIsoUtsFormat:String, position: Int){
        val dateFormat: Date = SimpleDateFormat("y-M-d H:m:s").parse(dateIsoUtsFormat)
        val firstPosFormat: Date = SimpleDateFormat("y-M-d H:m:s").parse(weatherInfo.list[0].dt_txt)
        var h =""
        var m = ""
        if(position == 0) date = "Now"
        else{
            if(dateFormat.hours<10) h="0"+dateFormat.hours
            else  h=""+dateFormat.hours
            if(dateFormat.minutes<10) m="0"+dateFormat.minutes
            else h =""+dateFormat.minutes
            if(dateFormat.day == firstPosFormat.day) date ="Today: " +h+ ":" +m
            else date= dayOfWeak[dateFormat.day]+": " +h+ ":" +m
        }
    }

    fun share(){
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/plain"
            val textToSend: String = "Weather for: $place \n" +
                    "Time: $date \n" +
                    "Air temperature: $temperature \n"+
                    "$feelsLike \n" +
                    "Humidity: $humidity \n" +
                    "Wind speed: $windSpeed \n" +
                    "Wind direction: $windDirection \n" +
                    "Cloudiness: $clouds \n"+
                    "Atmospheric pressure: $atmosphericPressure \n" +
                    "Precipitation volume in the last 3 hours: $rainFall"
            intent.putExtra(Intent.EXTRA_TEXT, textToSend)
            try {
                context.startActivity(Intent.createChooser(intent, context.getString(R.string.share)));
            } catch (ex: ActivityNotFoundException) {
                Toast.makeText(context.applicationContext, "Some error", Toast.LENGTH_SHORT).show()
            }
    }
}