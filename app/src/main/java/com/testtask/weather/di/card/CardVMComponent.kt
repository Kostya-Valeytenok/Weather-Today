package com.testtask.weather.di.card

import com.squareup.picasso.Picasso
import com.testtask.weather.Cache
import com.testtask.weather.di.BaseAppComponents
import com.testtask.weather.di.CacheComponents
import com.testtask.weather.di.scope.CardVMScope
import com.testtask.weather.di.scope.ForecastListScope
import dagger.Component

@Component(dependencies = [BaseAppComponents::class])
@CardVMScope
interface CardVMComponent {
    val getPicasso: Picasso
}