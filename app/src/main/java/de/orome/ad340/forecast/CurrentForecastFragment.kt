package de.orome.ad340.forecast

import android.content.Context
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
import de.orome.ad340.databinding.FragmentCurrentForecastBinding
import de.orome.ad340.details.ForecastDetailsActivity
import de.orome.ad340.interfaces.AppNavigator


class CurrentForecastFragment : Fragment() {

    private lateinit var binding: FragmentCurrentForecastBinding
    private lateinit var tempDisplaySettingManager: TempDisplaySettingManager
    private val repository = ForecastRepository()
    private val util = ForecastUtils()
    private lateinit var appNavigator: AppNavigator

    override fun onAttach(context: Context) {
        super.onAttach(context)
        /**
         * appNavigator initialisieren -> Funktionen aus Interface stehen im Fragment
         * -> Methoden aus AppNavigator stehen zur Verfügung
         */
        appNavigator = context as AppNavigator
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        tempDisplaySettingManager = TempDisplaySettingManager(requireContext())
        var zipCode = requireArguments().getString(KEY_ZIPCODE) ?: "12305"

        // Inflate the layout for this fragment
        binding = FragmentCurrentForecastBinding.inflate(inflater, container, false)
        val view: View = binding.root


        binding.rvForecastList.layoutManager = LinearLayoutManager(requireContext())

        val listAdapter: DailyForecastListAdapter =
            DailyForecastListAdapter(tempDisplaySettingManager) { forecast ->
                val message = getString(
                    R.string.toast_forecast_item_selected,
                    forecast.temperature,
                    forecast.description
                )
                showForecastDetails(forecast)
            }
        binding.rvForecastList.adapter = listAdapter

        binding.fabOpenLocationEntryFragment.setOnClickListener {
            appNavigator.navigateToLocationEntry()
        }

        // Observer des DailyForecast einrichten
        val weeklyForecastObserver = Observer<List<DailyForecast>> { forecastItems ->
            // update the ListAdapter when defined
            listAdapter.submitList(forecastItems)
            //Toast.makeText(this, forecastItems.toString(), Toast.LENGTH_LONG).show()
            Log.w("MyTag", forecastItems.toString())
        }
        repository.weeklyForecast.observe(viewLifecycleOwner, weeklyForecastObserver)

        repository.loadForecast(zipCode)
        return view
    }

    private fun showForecastDetails(forecast: DailyForecast) {

        val intentForecastDetails = Intent(requireContext(), ForecastDetailsActivity::class.java)
        intentForecastDetails.putExtra("key_temperature", forecast.temperature)
        intentForecastDetails.putExtra("key_description", forecast.description)
        startActivity(intentForecastDetails)
    }

    /**
     * to pass zipCode to Fragment, use companion object
     * new Instance method becomes factory method for the fragment
     * takes in values the fragment needs
     */
    companion object {
        const val KEY_ZIPCODE = "key_zipcode "

        fun newInstance(zipcode: String): CurrentForecastFragment {
            val fragment = CurrentForecastFragment()

            val args = Bundle()
            args.putString(KEY_ZIPCODE, zipcode)
            fragment.arguments = args
            return fragment
        }
    }


}