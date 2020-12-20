package com.testtask.weather.di.main

import android.content.SharedPreferences
import android.net.ConnectivityManager
import com.squareup.picasso.Picasso
import com.testtask.weather.Cache
import com.testtask.weather.di.BaseAppComponents
import com.testtask.weather.di.CacheComponents
import com.testtask.weather.di.scope.CardVMScope
import com.testtask.weather.di.scope.ForecastListScope
import com.testtask.weather.di.scope.MainActivityScope
import com.testtask.weather.di.scope.SplashScope
import com.testtask.weather.di.splash.NetworkDialogModule
import com.testtask.weather.dialogs.NetworkErrorDialog
import dagger.Component

@Component(modules = [NetworkDialogModule::class] ,dependencies = [BaseAppComponents::class])
@SplashScope
interface SplashComponent {
    var getPreference: SharedPreferences
    var networkDialog : NetworkErrorDialog
    var connectivityManager: ConnectivityManager
}