package de.orome.ad340

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import de.orome.ad340.details.ForecastDetailsActivity

class MainActivity : AppCompatActivity() {

    private lateinit var tempDisplaySettingManager: TempDisplaySettingManager
    // Repository festlegen
    private val repository = ForecastRepository()
    private val util = ForecastUtils()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tempDisplaySettingManager = TempDisplaySettingManager(this)
        
        var et_ZipCode: EditText = findViewById(R.id.et_PLZ)
        val btnEnter: Button = findViewById(R.id.btn_submit_zip_code)

        var zipCode:String = ""

        btnEnter.setOnClickListener{
            zipCode = et_ZipCode.text.toString()
            if (zipCode.length < 5){
                Toast.makeText(this, getString(R.string.err_msg_zip_code), Toast.LENGTH_SHORT).show()
            } else{
                repository.loadForecast(zipCode)
                //Toast.makeText(this.requireContext(),"PLZ: ${et_ZipCode.text.toString()}",Toast.LENGTH_SHORT).show()
            }
        }

        val rvForecastList: RecyclerView = findViewById(R.id.rv_forecast_list)
        rvForecastList.layoutManager = LinearLayoutManager(this)

        val listAdapter: DailyForecastListAdapter = DailyForecastListAdapter(tempDisplaySettingManager){ forecast ->
            val message = getString(R.string.toast_forecast_item_selected,forecast.temperature, forecast.description)
            showForecastDetails(forecast)
        }
        rvForecastList.adapter = listAdapter

        // Observer des DailyForecast einrichten
        val weeklyForecastObserver = Observer<List<DailyForecast>>{ forecastItems ->
            // update the ListAdapter when defined
            listAdapter.submitList(forecastItems)
            //Toast.makeText(this, forecastItems.toString(), Toast.LENGTH_LONG).show()
            Log.w("MyTag", forecastItems.toString() )
        }
        repository.weeklyForecast.observe(this, weeklyForecastObserver)







    }

    private fun showForecastDetails(forecast: DailyForecast){

        val intentForecastDetails = Intent(this, ForecastDetailsActivity::class.java)
        intentForecastDetails.putExtra("key_temperature", forecast.temperature)
        intentForecastDetails.putExtra("key_description", forecast.description)
        startActivity(intentForecastDetails)
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