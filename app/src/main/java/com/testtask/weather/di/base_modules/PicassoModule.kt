package com.testtask.weather.di.base_modules

import android.content.Context
import androidx.annotation.NonNull
import com.squareup.picasso.Picasso
import com.testtask.weather.di.ApplicationContext
import com.testtask.weather.di.scope.NetworkScope
import dagger.Module

import dagger.Provides


@Module(includes = [ContextModule::class])
class PicassoModule {

    @NetworkScope
    @Provides
    @NonNull
    fun picasso(@ApplicationContext context: Context): Picasso {
        return Picasso.with(context)
    }

}