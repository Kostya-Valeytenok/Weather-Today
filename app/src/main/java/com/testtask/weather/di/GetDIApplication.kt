package com.testtask.weather.di

import android.app.Activity
import android.app.Application
import com.testtask.weather.di.base_modules.ContextModule


class GetDIApplication : Application() {

    private lateinit var getDIAComponent: BaseAppComponents
    private lateinit var getCache: CacheComponents
    private lateinit var activity: Activity
    operator fun get(activity: Activity): GetDIApplication? {
        this.activity =activity;
        return activity.application as GetDIApplication
    }

    override fun onCreate() {
        super.onCreate()
        getCache = DaggerCacheComponents.builder().build()
        getDIAComponent = DaggerBaseAppComponents.builder().cacheComponents(getCache)
            .contextModule(ContextModule(this)).build()
    }

    fun getApplicationProvider(): BaseAppComponents {
        return getDIAComponent
    }

    fun IsComponentInit():Boolean{
        return this::getDIAComponent.isInitialized
    }
    fun getCache ():CacheComponents{
        return getCache
    }
}
