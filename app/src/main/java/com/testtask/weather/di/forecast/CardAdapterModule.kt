package com.testtask.weather.di.forecast

import androidx.fragment.app.FragmentActivity
import com.testtask.weather.CardViewAdapter
import com.testtask.weather.di.GetActivity
import com.testtask.weather.di.scope.ForecastFragmentScope
import com.testtask.weather.di.scope.TodayFragmentScope
import dagger.Module
import dagger.Provides

@Module(includes = [ActivityModule::class])
class CardAdapterModule {

    @ForecastFragmentScope
    @Provides
    fun getCardAdapter(@GetActivity act: FragmentActivity): CardViewAdapter {
        return CardViewAdapter(act)
    }
}