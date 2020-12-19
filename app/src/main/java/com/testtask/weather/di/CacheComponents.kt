package com.testtask.weather.di

import android.content.SharedPreferences
import com.squareup.picasso.Picasso
import com.testtask.weather.Cache
import com.testtask.weather.api.JSONPlaceHolderApi
import com.testtask.weather.di.base_modules.NetworkServiceModule
import com.testtask.weather.di.base_modules.PicassoModule
import com.testtask.weather.di.base_modules.PreferencesModule
import com.testtask.weather.di.scope.CacheSingletonScope
import com.testtask.weather.di.scope.NetworkScope
import dagger.Component


@CacheSingletonScope
@Component(modules = [CacheModule::class])
interface CacheComponents {
     val getCache: Cache
 //    var disabledLocation: LocationDialogModule
}
