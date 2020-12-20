package com.testtask.weather.di.card_view

import com.testtask.weather.databinding.BaseWatherItemsBinding
import com.testtask.weather.databinding.ForecastItemBinding
import com.testtask.weather.di.scope.CardVMScope
import com.testtask.weather.di.scope.CardViewScope
import com.testtask.weather.di.scope.ViewPagerScope
import com.testtask.weather.ui.forecast.CardViewModel
import com.testtask.weather.ui.today.ViewPagerViewModel
import dagger.Component

@Component(modules = [CardViewVMModule::class, CardViewBindingModule::class])
@CardViewScope
interface CardAdapterComponent {
    val getBinding: ForecastItemBinding
    val getVM: CardViewModel
}