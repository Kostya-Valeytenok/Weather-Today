package com.testtask.weather.di

import android.content.SharedPreferences
import android.net.ConnectivityManager
import com.squareup.picasso.Picasso
import com.testtask.weather.Cache
import com.testtask.weather.api.JSONPlaceHolderApi
import com.testtask.weather.di.base_modules.*
import com.testtask.weather.di.scope.NetworkScope
import dagger.Component
import java.text.SimpleDateFormat


@NetworkScope
@Component(modules = [PicassoModule::class, NetworkServiceModule::class,
     PreferencesModule::class, DataFormat::class, ConnectivityManagerModule::class], dependencies = [CacheComponents::class])
interface BaseAppComponents {

     val getPicasso: Picasso
     val getWeatherInfoFromApi: JSONPlaceHolderApi
     var getPreference: SharedPreferences
     var dataFormat:SimpleDateFormat
     var getCache: Cache
     var getConnectivityManager: ConnectivityManager
 //    var disabledLocation: LocationDialogModule
}
