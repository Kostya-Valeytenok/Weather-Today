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
import com.testtask.weather.di.forecast_list.DaggerForecastListComponent

class ForecastFragment : Fragment() {

    private var layoutManager: RecyclerView.LayoutManager? = null
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val forecastComponent= DaggerForecastListComponent.builder().cacheComponents(
            activity?.let { GetDIApplication().get(it)?.getCache() }).build()
        var bind:FragmentForecastBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_forecast, container, false)
        bind.viewModel = ForecastViewModel()
        val title = activity?.findViewById<TextView>(R.id.titleTextView)
        if(forecastComponent.getCache.isThereCache()) title?.text =forecastComponent.getCache.weatherInfoCache.city.name.toUpperCase()
        else title?.text = ""
        layoutManager = LinearLayoutManager(context)
        bind.forecastCardView.layoutManager = layoutManager
        if(forecastComponent.getCache.isThereCache())
        bind.forecastCardView.adapter  = activity?.let {CardViewAdapter(ForecastCreateList(requireActivity()).forecastList, it) }
        return bind.root
    }
}