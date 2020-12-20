package com.testtask.weather.di.forecast

import android.app.Activity
import androidx.fragment.app.FragmentActivity
import com.testtask.weather.ForecastCreateList
import com.testtask.weather.di.GetActivity
import com.testtask.weather.di.scope.ForecastFragmentScope
import dagger.Module
import dagger.Provides


@Module(includes = [ActivityModule::class])
class GetForecastListModule {

    @ForecastFragmentScope
    @Provides
    fun getList(@GetActivity context: FragmentActivity): ForecastCreateList {
        return ForecastCreateList(context)
    }

}