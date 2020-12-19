package com.testtask.weather.api.di.todayvm

import android.app.Activity
import com.testtask.weather.api.di.scope.TodayViewModuleScope
import com.testtask.weather.dialogs.DisabledLocation
import dagger.Module
import dagger.Provides

@Module
class LocationDialogModule( acts: Activity){

     var act: Activity = acts

    @Provides
    @TodayViewModuleScope
    fun getLocation():DisabledLocation{
        return DisabledLocation(act)
    }
}
