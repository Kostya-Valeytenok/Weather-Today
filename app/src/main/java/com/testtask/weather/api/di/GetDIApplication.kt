package com.testtask.weather.api.di

import android.app.Activity
import android.app.Application
import com.testtask.weather.api.di.modules.ContextModule


class GetDIApplication : Application() {
    private lateinit var getDIAComponent: BaseAppComponents
    private lateinit var activity: Activity
    operator fun get(activity: Activity): GetDIApplication? {
        this.activity =activity;
        return activity.application as GetDIApplication
    }

    override fun onCreate() {
        super.onCreate()
        getDIAComponent = DaggerBaseAppComponents.builder()
            .contextModule(ContextModule(this)).build()
    }

    fun getApplicationProvider(): BaseAppComponents {
        return getDIAComponent
    }
    fun IsComponentInit():Boolean{
        return this::getDIAComponent.isInitialized
    }
}
