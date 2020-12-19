package com.testtask.weather.ui.today

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.testtask.weather.Cache
import com.testtask.weather.R
import com.testtask.weather.ViewPagerAdapter
import com.testtask.weather.api.FiveDayWeatherJSON
import com.testtask.weather.databinding.FragmentTodayBinding
import com.testtask.weather.di.GetDIApplication
import com.testtask.weather.di.today_fragment.*
import io.reactivex.Observer
import io.reactivex.disposables.Disposable


class TodayFragment : Fragment() {

    var REQUEST_LOCATION_PERMISSIONS = 0;
    val permission = listOf(Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION)
    lateinit var bind: FragmentTodayBinding
    lateinit var fragmentComponent: TodayFragmentComponent
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        fragmentComponent  = DaggerTodayFragmentComponent.builder()
                .activityModule(activity?.let { ActivityModule(it) }).cacheComponents(activity?.let { GetDIApplication().get(it)?.getCache() })
                .fragmentTodayBindingModule(FragmentTodayBindingModule(inflater,container))
                .build()
        bind = fragmentComponent.getFragmentTodayBinding
        val title = activity?.findViewById<TextView>(R.id.titleTextView)
        title?.setText("TODAY")
        bind.viewModel =fragmentComponent.getVM
        if(fragmentComponent.getCache.isThereCache()){
            fragmentComponent.getTodayWeatherList.getTodayWeatherInfo(fragmentComponent.getCache.weatherInfoCache).subscribe(getObserverForTodayWeatherList())
        }
        else getWeatherInfoFromApi()
        return bind.root
    }

    private fun getObserverForTodayWeatherList(): Observer<FiveDayWeatherJSON> {
        return object : Observer<FiveDayWeatherJSON> {
            override fun onNext(t: FiveDayWeatherJSON?) {
                if (t != null) {
                    fragmentComponent.getViewPagerAdapter.weatherInfo = t
                    bind.todayViewPager.adapter =fragmentComponent.getViewPagerAdapter
                    bind.viewModel?.visible = View.INVISIBLE
                }
            }
            override fun onError(e: Throwable?) {}
            override fun onComplete() {}
            override fun onSubscribe(d: Disposable?) {}
        }
    }

    private fun getWeatherInfoFromApi(){
        if (hasLocationPermission()) {
            waitForWeatherInfo()
        } else {
            requestPermissions(permission.toTypedArray(),
                    REQUEST_LOCATION_PERMISSIONS);
            getWeatherInfoFromApi()
        }
    }
    private fun hasLocationPermission(): Boolean {
        val result = activity?.let {
            ContextCompat.checkSelfPermission(it, permission.get(0))
        }
        return result == PackageManager.PERMISSION_GRANTED
    }
    private fun waitForWeatherInfo(){
        val weathersObserver = getObserverForJsonData()
        bind.viewModel?.getWeatherForThisLocation()?.subscribe(weathersObserver)
    }
    private fun getObserverForJsonData(): Observer<FiveDayWeatherJSON> {
        return object : Observer<FiveDayWeatherJSON> {
            override fun onNext(t: FiveDayWeatherJSON?) {
               if( t != null) {
                    fragmentComponent.getCache.weatherInfoCache = t
                    fragmentComponent.getTodayWeatherList.getTodayWeatherInfo(t).subscribe(getObserverForTodayWeatherList())
                }
            }
            override fun onError(e: Throwable?) {}
            override fun onComplete() {}
            override fun onSubscribe(d: Disposable?) {}
        }
    }
}

