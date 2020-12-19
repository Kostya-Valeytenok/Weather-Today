package com.testtask.weather.api.di.modules

import android.content.Context
import com.testtask.weather.api.di.ApplicationContext
import com.testtask.weather.api.di.scope.NetworkScope
import dagger.Module
import dagger.Provides

@Module
class ContextModule(context: Context) {
    var context: Context = context

    @ApplicationContext
    @NetworkScope
    @Provides
    fun context(): Context {
        return context.applicationContext
    }

}