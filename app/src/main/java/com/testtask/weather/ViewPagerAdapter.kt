package com.testtask.weather

import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.testtask.weather.api.FiveDayWeatherJSON
import com.testtask.weather.databinding.BaseWatherItemsBinding
import com.testtask.weather.ui.today.ViewPagerViewModel

class ViewPagerAdapter(var contexts: Activity, var weatherInfo: FiveDayWeatherJSON) : RecyclerView.Adapter<PagerVH>() {

    private val colors = intArrayOf(
        android.R.color.black,
        android.R.color.holo_red_light,
        android.R.color.holo_blue_dark,
        android.R.color.holo_purple
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerVH {
        var  bind: BaseWatherItemsBinding = DataBindingUtil.inflate(LayoutInflater
                .from(parent.context),R.layout.base_wather_items, parent, false)
        return PagerVH(bind, contexts,weatherInfo)
    }

    override fun getItemCount(): Int = weatherInfo.list.size

    override fun onBindViewHolder(holder: PagerVH, position: Int) = holder.itemView.run {
        holder.VM.viewModel!!.setWeatherInfo(position) }
    }

class PagerVH(itemView: BaseWatherItemsBinding, context: Activity, weatherInfo: FiveDayWeatherJSON) : RecyclerView.ViewHolder(itemView.root){
    var VM: BaseWatherItemsBinding =itemView

    init { VM.viewModel = ViewPagerViewModel(context,weatherInfo) }
}
