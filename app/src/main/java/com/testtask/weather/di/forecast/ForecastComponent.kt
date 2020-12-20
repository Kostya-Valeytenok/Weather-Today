package com.testtask.weather.di.forecast

import android.content.SharedPreferences
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.testtask.weather.Cache
import com.testtask.weather.CardViewAdapter
import com.testtask.weather.ForecastCreateList
import com.testtask.weather.api.JSONPlaceHolderApi
import com.testtask.weather.databinding.FragmentForecastBinding
import com.testtask.weather.di.CacheComponents
import com.testtask.weather.di.scope.ForecastFragmentScope
import com.testtask.weather.di.scope.ForecastListScope
import com.testtask.weather.di.scope.TodayViewModuleScope
import com.testtask.weather.di.todayvm.TodayViewModelComponent
import com.testtask.weather.dialogs.DisabledLocation
import com.testtask.weather.ui.forecast.ForecastViewModel
import dagger.Component

@Component(modules = [FragmentForecastBindingModule::class, FragmentForecastVMModule::class, CardAdapterModule::class,
GetForecastListModule::class, LayoutManagerModule::class],  dependencies = [CacheComponents::class])
@ForecastFragmentScope
interface ForecastComponent {
    var getBindingModule:FragmentForecastBinding
    var getVM: ForecastViewModel
    var getCache: Cache
    var getCardViewAdapter: CardViewAdapter
    var getList :ForecastCreateList
    var getLayoutManage:LinearLayoutManager

}