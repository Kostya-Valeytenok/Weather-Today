package com.testtask.weather.di.pager

import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import com.testtask.weather.R
import com.testtask.weather.api.FiveDayWeatherJSON
import com.testtask.weather.databinding.FragmentTodayBinding
import com.testtask.weather.di.GetActivity
import com.testtask.weather.di.scope.ForecastFragmentScope
import com.testtask.weather.di.scope.TodayFragmentScope
import com.testtask.weather.di.scope.TodayViewModuleScope
import com.testtask.weather.di.scope.ViewPagerScope
import com.testtask.weather.di.today_fragment.ActivityModule
import com.testtask.weather.ui.forecast.ForecastViewModel
import com.testtask.weather.ui.today.TodayViewModel
import com.testtask.weather.ui.today.ViewPagerViewModel
import dagger.Module
import dagger.Provides

@Module
class ViewPagerVMModule(context: Activity, weatherInfo: FiveDayWeatherJSON) {

    val context= context
    var weatherInfo= weatherInfo

    @ViewPagerScope
    @Provides
    fun getFragmentForecastVM(): ViewPagerViewModel {
        return ViewPagerViewModel(context, weatherInfo)
    }
}