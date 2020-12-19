package com.testtask.weather.di

import android.content.SharedPreferences
import com.squareup.picasso.Picasso
import com.testtask.weather.api.JSONPlaceHolderApi
import com.testtask.weather.di.base_modules.NetworkServiceModule
import com.testtask.weather.di.base_modules.PicassoModule
import com.testtask.weather.di.base_modules.PreferencesModule
import com.testtask.weather.di.scope.NetworkScope
import dagger.Component


@NetworkScope
@Component(modules = [PicassoModule::class, NetworkServiceModule::class,
     PreferencesModule::class])
interface BaseAppComponents {

     val getPicasso: Picasso
     val getWeatherInfoFromApi: JSONPlaceHolderApi
     var getPreference: SharedPreferences
 //    var disabledLocation: LocationDialogModule
}
