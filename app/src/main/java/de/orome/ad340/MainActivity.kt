package de.orome.ad340

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    // Repository festlegen
    private val repository = ForecastRepository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        var et_ZipCode: EditText = findViewById(R.id.et_PLZ)
        val btnEnter: Button = findViewById(R.id.btn_submit_zip_code)
        val rvForecastList: RecyclerView = findViewById(R.id.rv_forecast_list)
        rvForecastList.layoutManager = LinearLayoutManager(this)
        val adapter: DailyForecastAdapter = DailyForecastAdapter(){forecast ->
            val message = getString(R.string.toast_forecast_item_selected,forecast.temperature, forecast.description)
            Toast.makeText(this, message,Toast.LENGTH_SHORT).show()
        }
        rvForecastList.adapter = adapter


        var zipCode:String = ""

        btnEnter.setOnClickListener{
            zipCode = et_ZipCode.text.toString()
            if (zipCode.length < 5){
                Toast.makeText(this, getString(R.string.err_msg_zip_code), Toast.LENGTH_SHORT).show()
            } else{
                repository.loadForecast(zipCode)
            //Toast.makeText(this,"PLZ: ${et_ZipCode.text.toString()}",Toast.LENGTH_SHORT).show()
            }
        }
        // Observer des DailyForecast einrichten
        val weeklyForecastObserver = Observer<List<DailyForecast>>{forecastItems ->
            // update the ListAdapter when defined
            adapter.submitList(forecastItems)
            //Toast.makeText(this, forecastItems.toString(), Toast.LENGTH_LONG).show()
            Log.w("MyTag", forecastItems.toString() )
        }
        repository.weeklyForacast.observe(this, weeklyForecastObserver)

    }





}