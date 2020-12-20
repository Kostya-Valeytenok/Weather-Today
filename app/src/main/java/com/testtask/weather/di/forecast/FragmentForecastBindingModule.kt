package com.testtask.weather.di.forecast

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.testtask.weather.R
import com.testtask.weather.databinding.FragmentForecastBinding
import com.testtask.weather.databinding.FragmentTodayBinding
import com.testtask.weather.di.scope.ForecastFragmentScope
import com.testtask.weather.di.scope.TodayFragmentScope
import com.testtask.weather.di.scope.TodayViewModuleScope
import dagger.Module
import dagger.Provides

@Module
class FragmentForecastBindingModule(ProvidesInflater: LayoutInflater,
                                    ProvidesContainer: ViewGroup?) {

    var inflater = ProvidesInflater;
    var container = ProvidesContainer
    @ForecastFragmentScope
    @Provides
    fun getFragmentForecastBinding(): FragmentForecastBinding {
        return DataBindingUtil.inflate(inflater, R.layout.fragment_forecast, container, false)
    }
}