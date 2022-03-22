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


}