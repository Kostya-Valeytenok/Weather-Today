package com.testtask.weather.di

import com.testtask.weather.api.JSONPlaceHolderApi
import com.testtask.weather.di.scope.CacheSingletonScope
import com.testtask.weather.di.scope.NetworkScope
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@Module
class CacheModule {

    @CacheSingletonScope
    @Provides
    fun getCache(): com.testtask.weather.Cache {
        return com.testtask.weather.Cache()
    }
}