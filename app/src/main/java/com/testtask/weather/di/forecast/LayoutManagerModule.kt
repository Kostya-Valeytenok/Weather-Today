package com.testtask.weather.di.forecast

import android.app.Activity
import android.content.Context
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.testtask.weather.di.ApplicationContext
import com.testtask.weather.di.GetActivity
import com.testtask.weather.di.scope.ForecastFragmentScope
import com.testtask.weather.di.scope.NetworkScope
import dagger.Module
import dagger.Provides


@Module(includes = [ActivityModule::class])
class LayoutManagerModule {

    @ForecastFragmentScope
    @Provides
    fun getLayoutManager(@GetActivity context: FragmentActivity): LinearLayoutManager {
        return LinearLayoutManager(context)
    }

}