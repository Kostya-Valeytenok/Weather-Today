package com.testtask.weather.di.base_modules

import android.app.Activity
import android.content.Context
import com.testtask.weather.di.GetActivity
import com.testtask.weather.di.scope.NetworkScope
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class ActivityContextModule {
    lateinit var  context: Context

    fun ActivityModule(@GetActivity context: Activity) {
        this.context = context
    }

    @Named("activity_context")
    @NetworkScope
    @Provides
    fun context(): Context? {
        return context
    }
}