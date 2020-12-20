package com.testtask.weather.di.card_view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.testtask.weather.R
import com.testtask.weather.databinding.BaseWatherItemsBinding
import com.testtask.weather.databinding.ForecastItemBinding
import com.testtask.weather.databinding.FragmentTodayBinding
import com.testtask.weather.di.scope.CardViewScope
import com.testtask.weather.di.scope.TodayFragmentScope
import com.testtask.weather.di.scope.TodayViewModuleScope
import com.testtask.weather.di.scope.ViewPagerScope
import dagger.Module
import dagger.Provides

@Module
class CardViewBindingModule(ProvidesInflater: LayoutInflater,
                            ProvidesContainer: ViewGroup?) {

    var inflater = ProvidesInflater;
    var container = ProvidesContainer

    @CardViewScope
    @Provides
    fun getBinding(): ForecastItemBinding {
        return DataBindingUtil.inflate(inflater, R.layout.forecast_item, container, false)
    }
}