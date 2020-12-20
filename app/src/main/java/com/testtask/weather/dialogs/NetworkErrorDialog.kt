package com.testtask.weather.dialogs

import android.R
import android.app.Activity
import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.location.Location
import android.net.ConnectivityManager
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.testtask.weather.MainActivity
import com.testtask.weather.di.GetDIApplication
import com.testtask.weather.di.main.DaggerSplashComponent
import com.testtask.weather.di.splash.NetworkDialogModule

class  NetworkErrorDialog(var activity: Activity) : DialogFragment() {

    val NetworkDialogComponent = DaggerSplashComponent.builder()
        .networkDialogModule(NetworkDialogModule(activity))
        .baseAppComponents(GetDIApplication().get(activity)!!.getApplicationProvider())
        .build()

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(activity)
        return builder
            .setTitle("Network Error")
            .setIcon(R.drawable.ic_dialog_alert)
            .setMessage("There is no Internet connection :(")
            .setPositiveButton("To try again") { dialog, which ->
                if (isConnected()) {
                    startActivity(Intent(activity, MainActivity::class.java))
                }
                else {
                    NetworkDialogComponent.networkDialog.show(parentFragmentManager, "ok")
                }
            }
            .setNegativeButton("Exit") { dialog, which -> activity.finish() }
            .create()
    }

    private fun isConnected(): Boolean {
        return if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            val network = NetworkDialogComponent.connectivityManager.activeNetwork
            val capabilities = NetworkDialogComponent.connectivityManager.getNetworkCapabilities(network)
            capabilities != null
        } else NetworkDialogComponent.connectivityManager.activeNetworkInfo != null
    }
}

