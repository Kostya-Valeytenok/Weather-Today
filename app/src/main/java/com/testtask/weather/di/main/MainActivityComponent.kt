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
import com.testtask.weather.dialogs.NetworkErrorDialog
import dagger.Component

@Component(dependencies = [BaseAppComponents::class])
@MainActivityScope
interface MainActivityComponent {
    var getPreference: SharedPreferences
}