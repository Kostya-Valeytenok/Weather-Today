package com.testtask.weather.di.pagervm

import android.widget.Toast
import com.squareup.picasso.Picasso
import com.testtask.weather.Cache
import com.testtask.weather.di.BaseAppComponents
import com.testtask.weather.di.CacheComponents
import com.testtask.weather.di.scope.CardVMScope
import com.testtask.weather.di.scope.ForecastListScope
import com.testtask.weather.di.scope.PagerVMScope
import dagger.Component
import java.text.SimpleDateFormat

@Component(dependencies = [BaseAppComponents::class])
@PagerVMScope
interface PagerVMComponent {
    val getPicasso: Picasso
    var dataFormat: SimpleDateFormat
}