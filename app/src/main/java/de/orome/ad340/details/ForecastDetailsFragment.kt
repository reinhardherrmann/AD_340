package de.orome.ad340.details


import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import de.orome.ad340.ForecastUtils
import de.orome.ad340.R
import de.orome.ad340.TempDisplaySettingManager
import de.orome.ad340.databinding.FragmentForecastDetailsBinding
import de.orome.ad340.interfaces.AppNavigator

class ForecastDetailsFragment : Fragment() {

    private val args: ForecastDetailsFragmentArgs by navArgs()
    private lateinit var binding: FragmentForecastDetailsBinding
    private lateinit var tempDisplaySettingManager: TempDisplaySettingManager
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


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentForecastDetailsBinding.inflate(inflater, container,false)
        val view = binding.root

        tempDisplaySettingManager = TempDisplaySettingManager(requireContext())

            binding.apply {
                tvForecastDetailsTemperature.text = util.formatTempForDisplay(args.temp,
                    tempDisplaySettingManager.getTempDisplaySetting())
                tvForecastDetailsDescription.text = args.description
            }

        return view
    }




//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        val inflater: MenuInflater = menuInflater
//        inflater.inflate(R.menu.mnu_settings, menu)
//        return true
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        // return super.onOptionsItemSelected(item)
//        return when (item.itemId) {
//            R.id.mnu_settings_select_temp_unit -> {
//                // TODO show Dialog to select the temp unit
//                util.showTempDisplaySettingDialog(this,tempDisplaySettingManager)
//                true
//            }
//            else -> super.onOptionsItemSelected(item)
//        }
//
//    }

//    private fun showTempDisplaySettingDialog() {
//        val dialogBuilder = AlertDialog.Builder(this)
//            .setTitle("Select Unit")
//            .setMessage("choose which temperature unit will be displayed.")
//            .setPositiveButton("°F") { _, _ ->
////                Toast.makeText(this@ForecastDetailsActivity, "°F selected", Toast.LENGTH_SHORT)
////                    .show()
//                tempDisplaySettingManager.updateSettings(TempDisplaySetting.Fahrenheit)
//            }
//            .setNeutralButton("°C") { _, _ ->
////                Toast.makeText(this@ForecastDetailsActivity, "°C selected", Toast.LENGTH_SHORT)
////                    .show()
//                tempDisplaySettingManager.updateSettings(TempDisplaySetting.Celsius)
//            }
//                // wird immer angezeigt
//            .setOnDismissListener {
//                Toast.makeText(this@ForecastDetailsActivity, "Setting will take affect on app restart", Toast.LENGTH_SHORT)
//                    .show()
//                //tempDisplaySettingManager.updateSettings(TempDisplaySetting.Celsius)
//            }
//        dialogBuilder.show()
//    }

}