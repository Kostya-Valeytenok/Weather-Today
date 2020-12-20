package com.testtask.weather.di.pager

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.testtask.weather.R
import com.testtask.weather.databinding.BaseWatherItemsBinding
import com.testtask.weather.databinding.FragmentTodayBinding
import com.testtask.weather.di.scope.TodayFragmentScope
import com.testtask.weather.di.scope.TodayViewModuleScope
import com.testtask.weather.di.scope.ViewPagerScope
import dagger.Module
import dagger.Provides

@Module
class WeatherItemBindingModule(ProvidesInflater: LayoutInflater,
                               ProvidesContainer: ViewGroup?) {

    var inflater = ProvidesInflater;
    var container = ProvidesContainer

    @ViewPagerScope
    @Provides
    fun getBinding(): BaseWatherItemsBinding {
        return DataBindingUtil.inflate(inflater, R.layout.base_wather_items, container, false)
    }
}