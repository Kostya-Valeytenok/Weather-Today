package com.testtask.weather.di.base_modules

import com.testtask.weather.api.JSONPlaceHolderApi
import com.testtask.weather.di.scope.NetworkScope
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@Module(includes = [OkHttpClientModule::class])
class NetworkServiceModule {
    private val BASE_URL = "https://api.openweathermap.org"

    @NetworkScope
    @Provides
    fun getApi(mRetrofit: Retrofit): JSONPlaceHolderApi {
        return mRetrofit.create(JSONPlaceHolderApi::class.java)
    }

    @NetworkScope
    @Provides
    fun getNetworkService(client:OkHttpClient,
                          gsonConverterFactory:GsonConverterFactory): Retrofit{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(gsonConverterFactory)
            .client(client)
            .build()
    }

    @Provides
    fun gsonConverterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }
}