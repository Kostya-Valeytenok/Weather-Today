package com.testtask.weather

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        if(androidx.preference.PreferenceManager.getDefaultSharedPreferences(this).getBoolean("Dark", false))
            setTheme(R.style.DarkTheme1)
        else setTheme(R.style.Theme_Weather)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM
        supportActionBar?.setCustomView(R.layout.abs_layout)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)
        val appBarConfiguration = AppBarConfiguration(setOf(
                R.id.navigation_home, R.id.navigation_dashboard))
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        when (id) {
            R.id.switch_theme -> {
                item.isEnabled = false
                if(androidx.preference.PreferenceManager.getDefaultSharedPreferences(this).getBoolean("Dark", false))
                    androidx.preference.PreferenceManager.getDefaultSharedPreferences(this)
                        .edit()
                        .putBoolean("Dark", false)
                        .apply()

                else androidx.preference.PreferenceManager.getDefaultSharedPreferences(this)
                        .edit()
                        .putBoolean("Dark", true)
                        .apply()

                val intent2 = intent
                startActivity(intent2)
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }
}