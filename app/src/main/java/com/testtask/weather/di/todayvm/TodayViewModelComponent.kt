package com.testtask.weather.di.todayvm

import android.content.SharedPreferences
import androidx.fragment.app.FragmentManager
import com.testtask.weather.api.JSONPlaceHolderApi
import com.testtask.weather.di.BaseAppComponents
import com.testtask.weather.di.base_modules.FragmentManagerModule
import com.testtask.weather.di.scope.TodayViewModuleScope
import com.testtask.weather.dialogs.DisabledLocation
import dagger.Component

@Component(modules = [LocationDialogModule::class, FragmentManagerModule::class], dependencies = [BaseAppComponents::class])
@TodayViewModuleScope
interface TodayViewModelComponent {
    val getWeatherInfoFromApi: JSONPlaceHolderApi
    var getPreference: SharedPreferences
    var disabledLocation: DisabledLocation
    var fragmentManager: FragmentManager
}