package com.testtask.weather.api.di.modules

import android.app.Activity
import androidx.fragment.app.FragmentManager
import com.testtask.weather.MainActivity
import com.testtask.weather.api.di.scope.TodayViewModuleScope
import dagger.Module
import dagger.Provides

@Module
class FragmentManagerModule(acts: Activity){

     var act: Activity = acts

    @Provides
    @TodayViewModuleScope
    fun getFragmentManager():FragmentManager {
        return (act as MainActivity).supportFragmentManager
    }
}
