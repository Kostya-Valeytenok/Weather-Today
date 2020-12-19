package com.testtask.weather.di.today_fragment

import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.testtask.weather.R
import com.testtask.weather.databinding.FragmentTodayBinding
import com.testtask.weather.di.scope.TodayFragmentScope
import com.testtask.weather.di.scope.TodayViewModuleScope
import com.testtask.weather.ui.today.TodayViewModel
import com.testtask.weather.ui.today.TodayWeatherList
import dagger.Module
import dagger.Provides

@Module
class TodayWeatherModule {

    @TodayFragmentScope
    @Provides
    fun getTodayWeatherList(): TodayWeatherList {
        return TodayWeatherList()
    }
}