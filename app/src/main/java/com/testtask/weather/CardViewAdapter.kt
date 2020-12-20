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
import com.testtask.weather.di.card_view.CardAdapterComponent
import com.testtask.weather.di.card_view.CardViewBindingModule
import com.testtask.weather.di.card_view.CardViewVMModule
import com.testtask.weather.di.card_view.DaggerCardAdapterComponent
import com.testtask.weather.di.forecast.CardAdapterModule
import com.testtask.weather.ui.forecast.CardViewModel
import com.testtask.weather.ui.forecast.ForecastItem

class CardViewAdapter(var activity: Activity) : RecyclerView.Adapter<CardViewHolder>() {

    lateinit var lists:ArrayList<ForecastItem>
    lateinit var bind:CardAdapterComponent

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        var view:View
        return if(lists[viewType].dayOfWeek == ""){
            getDiComponent(parent)
            CardViewHolder(bind,bind.getBinding.root,false, activity, lists)
        }
        else {
            view = LayoutInflater.from(parent.context).inflate(R.layout.day_item, parent, false)
            CardViewHolder(view, true, activity, lists)
        }
    }
    private fun getDiComponent(parent: ViewGroup){
        bind = DaggerCardAdapterComponent.builder()
            .cardViewBindingModule(CardViewBindingModule(LayoutInflater.from(parent.context),parent))
            .cardViewVMModule(CardViewVMModule(activity,lists))
            .build()
        bind.getBinding.viewModel = bind.getVM
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int): Unit = holder.itemView.run {
        if(!holder.typeOfList){ holder.binds.getBinding.viewModel!!.setDate(position) }
        else holder.dayOfWeakTextView.text=lists[position].dayOfWeek
    }

    override fun getItemCount(): Int = lists.size
    override fun getItemViewType(position: Int): Int {
        return position
    }
}

class CardViewHolder(itemView: View,var type:Boolean, var activity: Activity,var lists:ArrayList<ForecastItem> )
    : RecyclerView.ViewHolder(itemView) {

    constructor(bind:CardAdapterComponent, itemView: View, type:Boolean, activity: Activity, lists:ArrayList<ForecastItem> )
            : this(itemView,type,activity,lists){
        binds = bind
        this.type = type
    }

    lateinit var binds:CardAdapterComponent
    lateinit var dayOfWeakTextView:TextView
    var typeOfList:Boolean = false

    init {
        typeOfList = type
        if(type){  dayOfWeakTextView =itemView.findViewById(R.id.day_textView) }
    }
}
