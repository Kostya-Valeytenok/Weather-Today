package com.testtask.weather.di.pager

import com.testtask.weather.databinding.BaseWatherItemsBinding
import com.testtask.weather.di.scope.ViewPagerScope
import com.testtask.weather.ui.today.ViewPagerViewModel
import dagger.Component

@Component(modules = [WeatherItemBindingModule::class, ViewPagerVMModule::class])
@ViewPagerScope
interface ViewPagerComponent {
    val getBinding: BaseWatherItemsBinding
    val getVM: ViewPagerViewModel
}