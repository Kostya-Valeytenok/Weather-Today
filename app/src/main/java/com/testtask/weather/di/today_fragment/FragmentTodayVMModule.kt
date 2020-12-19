package com.testtask.weather.di.today_fragment

import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import com.testtask.weather.R
import com.testtask.weather.databinding.FragmentTodayBinding
import com.testtask.weather.di.GetActivity
import com.testtask.weather.di.scope.TodayFragmentScope
import com.testtask.weather.di.scope.TodayViewModuleScope
import com.testtask.weather.ui.today.TodayViewModel
import dagger.Module
import dagger.Provides

@Module(includes = [ActivityModule::class])
class FragmentTodayVMModule {

    @TodayFragmentScope
    @Provides
    fun getFragmentTodayBinding(@GetActivity act: FragmentActivity): TodayViewModel {
        return TodayViewModel(act)
    }
}