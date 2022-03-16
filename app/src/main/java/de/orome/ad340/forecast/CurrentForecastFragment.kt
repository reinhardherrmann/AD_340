package de.orome.ad340.forecast

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import de.orome.ad340.*
import de.orome.ad340.details.ForecastDetailsActivity

class CurrentForecastFragment : Fragment() {

    private lateinit var tempDisplaySettingManager: TempDisplaySettingManager

    val zipcode = arguments!!.getString(KEY_ZIPCODE) ?: ""
    // Repository festlegen
    private val repository = ForecastRepository()
    private val util = ForecastUtils()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        tempDisplaySettingManager = TempDisplaySettingManager(requireContext())
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_current_forecast, container, false)

        val rvForecastList: RecyclerView = view.findViewById(R.id.rv_forecast_list)
        rvForecastList.layoutManager = LinearLayoutManager(requireContext())

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
        repository.weeklyForecast.observe(viewLifecycleOwner, weeklyForecastObserver)

        repository.loadForecast(zipcode)


        return view
    }

    private fun showForecastDetails(forecast: DailyForecast){

        val intentForecastDetails = Intent(requireContext(), ForecastDetailsActivity::class.java)
        intentForecastDetails.putExtra("key_temperature", forecast.temperature)
        intentForecastDetails.putExtra("key_description", forecast.description)
        startActivity(intentForecastDetails)
    }

    companion object{
        const val KEY_ZIPCODE = "key_zipcode"

        fun newInstance(zipcode: String): CurrentForecastFragment{
            val fragment = CurrentForecastFragment()

            val args = Bundle()
            args.putString(KEY_ZIPCODE, zipcode)
            fragment.arguments = args

            return fragment
        }
    }

}