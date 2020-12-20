package com.testtask.weather.di.forecast

import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import com.testtask.weather.R
import com.testtask.weather.databinding.FragmentTodayBinding
import com.testtask.weather.di.GetActivity
import com.testtask.weather.di.scope.ForecastFragmentScope
import com.testtask.weather.di.scope.TodayFragmentScope
import com.testtask.weather.di.scope.TodayViewModuleScope
import com.testtask.weather.di.today_fragment.ActivityModule
import com.testtask.weather.ui.forecast.ForecastViewModel
import com.testtask.weather.ui.today.TodayViewModel
import dagger.Module
import dagger.Provides

@Module
class FragmentForecastVMModule() {

    @ForecastFragmentScope
    @Provides
    fun getFragmentForecastVM(): ForecastViewModel {
        return ForecastViewModel()
    }
}