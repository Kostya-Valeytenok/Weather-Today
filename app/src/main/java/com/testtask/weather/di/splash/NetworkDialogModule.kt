package com.testtask.weather.di.splash

import android.app.Activity
import com.testtask.weather.di.scope.SplashScope
import com.testtask.weather.di.scope.TodayViewModuleScope
import com.testtask.weather.dialogs.DisabledLocation
import com.testtask.weather.dialogs.NetworkErrorDialog
import dagger.Module
import dagger.Provides

@Module
class NetworkDialogModule(acts: Activity){

     var act: Activity = acts

    @Provides
    @SplashScope
    fun getNetwork(): NetworkErrorDialog {
        return NetworkErrorDialog(act)
    }
}
