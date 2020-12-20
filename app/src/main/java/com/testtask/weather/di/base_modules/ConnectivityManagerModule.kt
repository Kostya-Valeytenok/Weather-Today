package com.testtask.weather.di.base_modules

import android.content.Context
import android.net.ConnectivityManager
import com.testtask.weather.di.ApplicationContext
import com.testtask.weather.di.scope.NetworkScope
import dagger.Module
import dagger.Provides

@Module
class ConnectivityManagerModule {

    @NetworkScope
    @Provides
    fun getConnectivityManager(@ApplicationContext context: Context): ConnectivityManager {
        return context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    }

}