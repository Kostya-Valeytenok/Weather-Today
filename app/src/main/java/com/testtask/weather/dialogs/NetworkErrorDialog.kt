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

class NetworkErrorDialog(var activity: Activity) : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(activity)
        return builder
            .setTitle("Network Error")
            .setIcon(R.drawable.ic_dialog_alert)
            .setMessage("There is no Internet connection :(")
            .setPositiveButton("To try again") { dialog, which ->
                if (isConnected(activity)) {
                    startActivity(Intent(activity, MainActivity::class.java))
                }
                else {
                    val d = NetworkErrorDialog(activity)
                    d.show(parentFragmentManager, "ok")
                }
            }
            .setNegativeButton("Exit") { dialog, which -> activity.finish() }
            .create()
    }

    private fun isConnected(context: Context): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            val network = connectivityManager.activeNetwork
            val capabilities = connectivityManager.getNetworkCapabilities(network)
            capabilities != null
        } else {
            connectivityManager.activeNetworkInfo != null
        }
    }
}

