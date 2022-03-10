package de.orome.ad340.details


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import de.orome.ad340.ForecastUtils
import de.orome.ad340.R

class ForecastDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val util = ForecastUtils()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forecast_details)

        setTitle(R.string.lbl_activity_forecast_details)

        val tvTemperature: TextView = findViewById(R.id.tv_forecast_details_temperature)
        val tvDescription: TextView = findViewById(R.id.tv_forecast_details_description)

        // get the extras of the intent and display in TextViews
        val temp = intent.getFloatExtra("key_temperature", 0f)
        tvTemperature.text = util.formatTempForDisplay(temp)
        tvDescription.text = "${intent.getStringExtra("key_description")}"

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
                showTempDisplaySettingDialog()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }

    }

    private fun showTempDisplaySettingDialog() {
        val dialogBuilder = AlertDialog.Builder(this)
            .setTitle("Select Unit")
            .setMessage("choose which temperature unit will be displayed.")
            .setPositiveButton("°F") { _, _ ->
                Toast.makeText(this@ForecastDetailsActivity, "°F selected", Toast.LENGTH_SHORT)
                    .show()
            }
            .setNeutralButton("°C") { _, _ ->
                Toast.makeText(this@ForecastDetailsActivity, "°C selected", Toast.LENGTH_SHORT)
                    .show()
            }
            .setOnDismissListener {
                Toast.makeText(this@ForecastDetailsActivity, "Setting will take affect on app restart", Toast.LENGTH_SHORT)
                    .show()
            }
        dialogBuilder.show()
    }

}