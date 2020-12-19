package com.testtask.weather

import android.app.Activity
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.testtask.weather.databinding.ForecastItemBinding
import com.testtask.weather.ui.forecast.CardViewModel
import com.testtask.weather.ui.forecast.ForecastItem

class CardViewAdapter(list:ArrayList<ForecastItem>, var activity: Activity) : RecyclerView.Adapter<CardViewHolder>() {

    private var lists:ArrayList<ForecastItem> = list

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        var view:View
        return if(lists[viewType].dayOfWeek == ""){
            val bind: ForecastItemBinding = DataBindingUtil.inflate(LayoutInflater
                    .from(parent.context),R.layout.forecast_item, parent, false)
            CardViewHolder(bind,bind.root,false, activity, lists)
        }
        else {
            view = LayoutInflater.from(parent.context).inflate(R.layout.day_item, parent, false)
            CardViewHolder(view, true, activity, lists)
        }
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int): Unit = holder.itemView.run {
        if(!holder.typeOfList){ holder.binds.viewModel!!.setDate(position) }
        else holder.dayOfWeakTextView.text=lists[position].dayOfWeek
    }
    override fun getItemCount(): Int = lists.size
    override fun getItemViewType(position: Int): Int {
        return position
    }
}

class CardViewHolder(itemView: View,var type:Boolean, var activity: Activity,var lists:ArrayList<ForecastItem> ) : RecyclerView.ViewHolder(itemView) {

    constructor(bind:ForecastItemBinding, itemView: View, type:Boolean, activity: Activity, lists:ArrayList<ForecastItem> ): this(itemView,type,activity,lists){
        binds = bind
        this.type = type
        binds.viewModel = CardViewModel(lists, activity)
    }
    lateinit var binds:ForecastItemBinding
    lateinit var dayOfWeakTextView:TextView
    var typeOfList:Boolean = false

    init {
        typeOfList = type
        if(type){  dayOfWeakTextView =itemView.findViewById(R.id.day_textView) }
    }
}
