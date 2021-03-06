package com.testtask.weather.di.forecast_list

import com.testtask.weather.Cache
import com.testtask.weather.di.BaseAppComponents
import com.testtask.weather.di.CacheComponents
import com.testtask.weather.di.scope.ForecastListScope
import dagger.Component
import java.text.SimpleDateFormat

@Component(dependencies = [BaseAppComponents::class])
@ForecastListScope
interface ForecastListComponent {
    var getCache: Cache
    var dataFormat: SimpleDateFormat
}