package com.testtask.weather.di.today_fragment

import com.testtask.weather.Cache
import com.testtask.weather.ViewPagerAdapter
import com.testtask.weather.databinding.FragmentTodayBinding
import com.testtask.weather.di.BaseAppComponents
import com.testtask.weather.di.CacheComponents
import com.testtask.weather.di.CacheModule
import com.testtask.weather.di.scope.TodayFragmentScope
import com.testtask.weather.ui.today.TodayViewModel
import com.testtask.weather.ui.today.TodayWeatherList
import dagger.Component

@Component(modules =  [FragmentTodayBindingModule::class, FragmentTodayVMModule::class,
    TodayWeatherModule::class, ViewPagerModule::class], dependencies = [CacheComponents::class])

@TodayFragmentScope
interface TodayFragmentComponent {
    val getFragmentTodayBinding: FragmentTodayBinding
    val getVM: TodayViewModel
    val getTodayWeatherList:TodayWeatherList
    val getViewPagerAdapter:ViewPagerAdapter
    var getCache:Cache
}