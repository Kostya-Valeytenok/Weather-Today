package com.testtask.weather

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.testtask.weather.di.GetDIApplication
import com.testtask.weather.di.main.DaggerSplashComponent
import com.testtask.weather.di.main.SplashComponent
import com.testtask.weather.di.splash.NetworkDialogModule
import com.testtask.weather.dialogs.NetworkErrorDialog

class Splash : AppCompatActivity() {

    lateinit var splashComponent:SplashComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        splashComponent = DaggerSplashComponent.builder()
            .baseAppComponents(GetDIApplication().get(this)!!.getApplicationProvider())
            .networkDialogModule(NetworkDialogModule(this))
            .build()
        super.onCreate(savedInstanceState)
        if(isConnected()) {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
        else splashComponent.networkDialog.show(supportFragmentManager,"ok")

    }
    private fun isConnected(): Boolean {
        return if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            val network = splashComponent.connectivityManager.activeNetwork
            val capabilities = splashComponent.connectivityManager.getNetworkCapabilities(network)
            capabilities != null
        } else {
            splashComponent.connectivityManager.activeNetworkInfo != null
        }
    }
}