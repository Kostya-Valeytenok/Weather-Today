package com.testtask.weather

import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.testtask.weather.api.FiveDayWeatherJSON
import com.testtask.weather.databinding.BaseWatherItemsBinding
import com.testtask.weather.di.pager.DaggerViewPagerComponent
import com.testtask.weather.di.pager.ViewPagerComponent
import com.testtask.weather.di.pager.ViewPagerVMModule
import com.testtask.weather.di.pager.WeatherItemBindingModule
import com.testtask.weather.ui.today.ViewPagerViewModel
import javax.inject.Inject

class ViewPagerAdapter(var contexts: Activity) : RecyclerView.Adapter<PagerVH>() {

    lateinit var weatherInfo: FiveDayWeatherJSON
    lateinit var viewPagerComponent:ViewPagerComponent

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerVH {
        viewPagerComponent = DaggerViewPagerComponent.builder()
            .weatherItemBindingModule(WeatherItemBindingModule(LayoutInflater.from(parent.context), parent))
            .viewPagerVMModule(ViewPagerVMModule(contexts,weatherInfo))
            .build()
        return PagerVH(viewPagerComponent.getBinding, viewPagerComponent)
    }

    override fun getItemCount(): Int = weatherInfo.list.size

    override fun onBindViewHolder(holder: PagerVH, position: Int) = holder.itemView.run {
        holder.VM.viewModel!!.setWeatherInfo(position) }
    }

class PagerVH(itemView: BaseWatherItemsBinding, v:ViewPagerComponent) : RecyclerView.ViewHolder(itemView.root){
    var VM: BaseWatherItemsBinding =itemView
    init { VM.viewModel = v.getVM}
}
