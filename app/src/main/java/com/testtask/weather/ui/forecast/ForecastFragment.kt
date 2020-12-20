package com.testtask.weather.ui.forecast

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.testtask.weather.*
import com.testtask.weather.databinding.FragmentForecastBinding
import com.testtask.weather.di.GetDIApplication
import com.testtask.weather.di.forecast.*
import com.testtask.weather.di.forecast_list.DaggerForecastListComponent

class ForecastFragment : Fragment() {

    lateinit var forecastComponent:ForecastComponent
    lateinit var bind:FragmentForecastBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        getDiComponent(inflater,container)
        createBinding()
        setTitle()
        setForecastListWeather()
        return bind.root
    }
    private fun getDiComponent(inflater: LayoutInflater, container: ViewGroup?){
        forecastComponent= DaggerForecastComponent.builder()
            .cacheComponents(activity?.let { GetDIApplication().get(it)?.getCache() })
            .fragmentForecastBindingModule(FragmentForecastBindingModule(inflater,container))
            .fragmentForecastVMModule(FragmentForecastVMModule())
            .activityModule(activity?.let { ActivityModule(it) })
            .build()
    }
    private fun createBinding(){
        bind =forecastComponent.getBindingModule
        bind.viewModel = forecastComponent.getVM
    }
    private fun setTitle(){
        val title = activity?.findViewById<TextView>(R.id.titleTextView)
        if(forecastComponent.getCache.isThereCache())
            title?.text =forecastComponent.getCache.weatherInfoCache.city.name.toUpperCase()
        else title?.text = ""
    }
    private fun setForecastListWeather(){
        bind.forecastCardView.layoutManager = forecastComponent.getLayoutManage
        if(forecastComponent.getCache.isThereCache()) {
            var adapter= forecastComponent.getCardViewAdapter
            adapter.lists = forecastComponent.getList.forecastList
            bind.forecastCardView.adapter = adapter
        }
    }
}