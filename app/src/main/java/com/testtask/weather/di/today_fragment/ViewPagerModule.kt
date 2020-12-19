package com.testtask.weather.di.today_fragment

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import com.testtask.weather.R
import com.testtask.weather.ViewPagerAdapter
import com.testtask.weather.api.FiveDayWeatherJSON
import com.testtask.weather.databinding.FragmentTodayBinding
import com.testtask.weather.di.GetActivity
import com.testtask.weather.di.scope.TodayFragmentScope
import com.testtask.weather.di.scope.TodayViewModuleScope
import com.testtask.weather.ui.today.TodayViewModel
import com.testtask.weather.ui.today.TodayWeatherList
import dagger.Module
import dagger.Provides

@Module(includes = [ActivityModule::class])
class ViewPagerModule {

    @TodayFragmentScope
    @Provides
    fun getViewPageAdapter(@GetActivity act: FragmentActivity): ViewPagerAdapter {
        return ViewPagerAdapter(act)
    }
}