package com.testtask.weather.di.base_modules

import android.content.Context
import com.testtask.weather.di.ApplicationContext
import com.testtask.weather.di.scope.NetworkScope
import dagger.Module
import dagger.Provides
import java.text.SimpleDateFormat


@Module
class DataFormat {

    @NetworkScope
    @Provides
    fun getDataFormat(): SimpleDateFormat {
        return SimpleDateFormat("y-M-d H:m:s")
    }

}