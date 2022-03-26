package de.orome.ad340

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {

    private lateinit var tempDisplaySettingManager: TempDisplaySettingManager

    private val util = ForecastUtils()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tempDisplaySettingManager = TempDisplaySettingManager(this)

        val navController = findNavController(R.id.nav_host_fragment)
        val appBarConfiguration = AppBarConfiguration(navController.graph)
        findViewById<Toolbar>(R.id.toolbar).setTitle(R.string.app_name) //.setupWithNavController(navController, appBarConfiguration)
        findViewById<BottomNavigationView>(R.id.bottomNavigationView).setupWithNavController(navController)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.mnu_settings, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // return super.onOptionsItemSelected(item)
        return when (item.itemId) {
            R.id.mnu_settings_select_temp_unit -> {
                // TODO show Dialog to select the temp unit
                util.showTempDisplaySettingDialog(this,tempDisplaySettingManager)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }

    }


}