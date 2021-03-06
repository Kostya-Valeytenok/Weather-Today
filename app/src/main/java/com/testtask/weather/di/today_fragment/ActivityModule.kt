package com.testtask.weather.di.today_fragment

import android.app.Activity
import android.content.Context
import androidx.fragment.app.FragmentActivity
import com.testtask.weather.di.ApplicationContext
import com.testtask.weather.di.GetActivity
import com.testtask.weather.di.base_modules.OkHttpClientModule
import com.testtask.weather.di.scope.NetworkScope
import com.testtask.weather.di.scope.TodayFragmentScope
import dagger.Module
import dagger.Provides


@Module
class ActivityModule(context: FragmentActivity) {

    var context: FragmentActivity = context

    @GetActivity
    @TodayFragmentScope
    @Provides
    fun getActivity():FragmentActivity {
        return context
    }

}