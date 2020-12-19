package com.testtask.weather.dialogs

import android.R
import android.app.Activity
import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class DisabledLocation(var activity: Activity) : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(activity)
        return builder.setTitle("Location Error")
                .setIcon(R.drawable.ic_dialog_alert)
                .setMessage("We've uploaded the weather for the last known location :(")
                .setPositiveButton("Ок") { dialog, which -> }
                .setNegativeButton("Exit") { dialog, which -> activity.finish() }
                .create()
    }
}
