package com.testtask.weather.di.card_view

import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import com.testtask.weather.R
import com.testtask.weather.api.FiveDayWeatherJSON
import com.testtask.weather.databinding.FragmentTodayBinding
import com.testtask.weather.di.GetActivity
import com.testtask.weather.di.scope.*
import com.testtask.weather.di.today_fragment.ActivityModule
import com.testtask.weather.ui.forecast.CardViewModel
import com.testtask.weather.ui.forecast.ForecastItem
import com.testtask.weather.ui.forecast.ForecastViewModel
import com.testtask.weather.ui.today.TodayViewModel
import com.testtask.weather.ui.today.ViewPagerViewModel
import dagger.Module
import dagger.Provides

@Module
class CardViewVMModule(var activity: Activity, lists:ArrayList<ForecastItem>) {

    val context= activity
    var weatherInfo= lists

    @CardViewScope
    @Provides
    fun getFragmentForecastVM(): CardViewModel {
        return CardViewModel(weatherInfo, context)
    }
}