package com.testtask.weather.di.forecast_list

import com.testtask.weather.Cache
import com.testtask.weather.di.CacheComponents
import com.testtask.weather.di.scope.ForecastListScope
import dagger.Component

@Component(dependencies = [CacheComponents::class])
@ForecastListScope
interface ForecastListComponent {
    var getCache: Cache
}