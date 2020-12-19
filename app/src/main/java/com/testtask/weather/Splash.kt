package com.testtask.weather

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.testtask.weather.dialogs.NetworkErrorDialog

class Splash : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if(isConnected(this)) {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
        else{
            val d = NetworkErrorDialog(this)
            d.show(this.supportFragmentManager, "ok")
        }

    }
    private fun isConnected(context: Context): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            val network = connectivityManager.activeNetwork
            val capabilities = connectivityManager.getNetworkCapabilities(network)
            capabilities != null
        } else {
            connectivityManager.activeNetworkInfo != null
        }
    }
}