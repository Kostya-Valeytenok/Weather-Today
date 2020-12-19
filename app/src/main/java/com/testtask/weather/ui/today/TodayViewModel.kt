package com.testtask.weather.ui.today

import android.annotation.SuppressLint
import android.app.Activity
import android.location.Location
import android.view.View
import androidx.databinding.BaseObservable
import androidx.fragment.app.FragmentManager
import com.google.android.gms.location.LocationServices
import com.testtask.weather.BR
import com.testtask.weather.MainActivity
import com.testtask.weather.R
import com.testtask.weather.api.FiveDayWeatherJSON
import com.testtask.weather.api.di.GetDIApplication
import com.testtask.weather.api.di.modules.FragmentManagerModule
import com.testtask.weather.api.di.todayvm.DaggerTodayViewModelComponent
import com.testtask.weather.api.di.todayvm.LocationDialogModule
import com.testtask.weather.dialogs.DisabledLocation
import io.reactivex.Observable
import io.reactivex.ObservableEmitter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class TodayViewModel(var context: Activity) : BaseObservable() {

    var todayVMComponent = DaggerTodayViewModelComponent.builder().locationDialogModule(
        LocationDialogModule(context)).baseAppComponents(GetDIApplication().get(context)!!.
    getApplicationProvider()).fragmentManagerModule(FragmentManagerModule(context)).build()

    var latitude: Double = 0.0
    var longitude: Double = 0.0
    var visible: Int = View.VISIBLE
    lateinit var weatherInfo: FiveDayWeatherJSON
    internal var trys = 0
    var isGpsOn = true

    @SuppressLint("MissingPermission")
    fun getWeatherForThisLocation(): Observable<FiveDayWeatherJSON> {
        val myObservable: Observable<FiveDayWeatherJSON> = Observable.create { subscriber ->
            val fusedLocationClient = context.let { LocationServices.getFusedLocationProviderClient(it) }
            fusedLocationClient?.lastLocation?.addOnSuccessListener { location: Location? ->
                try {
                    latitude = location?.latitude!!
                    longitude = location.longitude
                }
                catch (k: KotlinNullPointerException) { getCacheAndShowMessage() }
                finally {
                    if(isGpsOn) saveLocationAsCache()
                        setWeatherInfo(subscriber)
                }
            }
        }
        return myObservable
    }
    private fun getCacheAndShowMessage(){
        isGpsOn = false
        getCache()
        todayVMComponent.disabledLocation.show(todayVMComponent.fragmentManager, "ok")
    }
    private fun getCache(){
        latitude = todayVMComponent.getPreference.getFloat("latitude", 0F).toDouble()
        longitude = todayVMComponent.getPreference.getFloat("longitude", 0F).toDouble()
    }
    private fun saveLocationAsCache(){
        var addLocationCache = Thread(Runnable { todayVMComponent.getPreference.edit()
            .putFloat("latitude", latitude.toFloat())
            .putFloat("longitude", longitude.toFloat())
            .apply()
        })
        addLocationCache.start()
    }
    private fun setWeatherInfo(subscriber: ObservableEmitter<FiveDayWeatherJSON>){

        todayVMComponent.getWeatherInfoFromApi.getInfo(latitude, longitude,
                context.getString(R.string.api_key)).enqueue(object : Callback<FiveDayWeatherJSON> {
            override fun onResponse(call: Call<FiveDayWeatherJSON>, response: Response<FiveDayWeatherJSON>) {
                if (response.body() != null) {
                    weatherInfo = response.body()
                    subscriber.onNext(weatherInfo)
                    subscriber.onComplete()
                    visible = View.INVISIBLE
                    notifyPropertyChanged(BR._all)
                }
            }
            override fun onFailure(call: Call<FiveDayWeatherJSON>, t: Throwable) {}
        })
    }
}