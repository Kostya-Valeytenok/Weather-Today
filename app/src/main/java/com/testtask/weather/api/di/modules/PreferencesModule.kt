package com.testtask.weather.api.di.modules

import android.content.Context
import android.content.SharedPreferences
import com.testtask.weather.api.di.ApplicationContext
import com.testtask.weather.api.di.scope.NetworkScope
import dagger.Module
import dagger.Provides

@Module(includes = [ContextModule::class])
class PreferencesModule() {

    @NetworkScope
    @Provides
    fun getPreference(@ApplicationContext context: Context): SharedPreferences {
        return androidx.preference.PreferenceManager.getDefaultSharedPreferences(context)
    }

}