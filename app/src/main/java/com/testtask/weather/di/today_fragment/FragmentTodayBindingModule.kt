package com.testtask.weather.di.today_fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.testtask.weather.R
import com.testtask.weather.databinding.FragmentTodayBinding
import com.testtask.weather.di.scope.TodayFragmentScope
import com.testtask.weather.di.scope.TodayViewModuleScope
import dagger.Module
import dagger.Provides

@Module
class FragmentTodayBindingModule(ProvidesInflater: LayoutInflater,
                                 ProvidesContainer: ViewGroup?) {

    var inflater = ProvidesInflater;
    var container = ProvidesContainer
    @TodayFragmentScope
    @Provides
    fun getFragmentTodayBinding(): FragmentTodayBinding {
        return DataBindingUtil.inflate(inflater, R.layout.fragment_today, container, false)
    }
}