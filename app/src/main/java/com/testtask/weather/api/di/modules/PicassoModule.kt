package com.testtask.weather.api.di.modules

import android.content.Context
import androidx.annotation.NonNull
import com.squareup.picasso.Picasso
import com.testtask.weather.api.di.ApplicationContext
import com.testtask.weather.api.di.scope.NetworkScope
import dagger.Module

import dagger.Provides
import javax.inject.Named


@Module(includes = [ContextModule::class])
class PicassoModule {

    @NetworkScope
    @Provides
    @NonNull
    fun picasso(@ApplicationContext context: Context): Picasso {
        return Picasso.with(context)
    }

}