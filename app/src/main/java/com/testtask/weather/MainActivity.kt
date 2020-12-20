package com.testtask.weather

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.testtask.weather.di.GetDIApplication
import com.testtask.weather.di.main.DaggerMainActivityComponent
import com.testtask.weather.di.main.MainActivityComponent


class MainActivity : AppCompatActivity() {

    var isDarkTheme = false
    lateinit var mainActivityComponent:MainActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        getDiComponent()
        if(mainActivityComponent.getPreference.getBoolean("Dark", false)) {
            setTheme(R.style.DarkTheme1)
            isDarkTheme =true
        }
        else setTheme(R.style.Theme_Weather)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM
        supportActionBar?.setCustomView(R.layout.abs_layout)
        if(isDarkTheme)
            supportActionBar?.setBackgroundDrawable(ContextCompat.getDrawable(this,R.color.gray_900))
        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)
        val appBarConfiguration = AppBarConfiguration(setOf(
                R.id.navigation_home, R.id.navigation_dashboard))
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }
    private fun getDiComponent(){
        mainActivityComponent = DaggerMainActivityComponent.builder()
            .baseAppComponents(GetDIApplication().get(this)!!.getApplicationProvider())
            .build()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        when (id) {
            R.id.switch_theme -> {
                item.isEnabled = false

                if(mainActivityComponent.getPreference.getBoolean("Dark", false))
                    mainActivityComponent.getPreference.edit().putBoolean("Dark", false).apply()
                else
                    mainActivityComponent.getPreference.edit().putBoolean("Dark", true).apply()

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