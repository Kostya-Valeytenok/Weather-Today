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

class ForecastFragment : Fragment() {

    private var layoutManager: RecyclerView.LayoutManager? = null
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        var bind:FragmentForecastBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_forecast, container, false)
        bind.viewModel = ForecastViewModel()
        val title = activity?.findViewById<TextView>(R.id.titleTextView)
        if(Cache.INSTANCE.isThereCache()) title?.text =Cache.INSTANCE.weatherInfoCache.city.name.toUpperCase()
        else title?.text = ""
        layoutManager = LinearLayoutManager(context)
        bind.forecastCardView.layoutManager = layoutManager
        if(Cache.INSTANCE.isThereCache())
        bind.forecastCardView.adapter  = activity?.let {CardViewAdapter(ForecastCreateList().forecastList, it) }
        return bind.root
    }
}