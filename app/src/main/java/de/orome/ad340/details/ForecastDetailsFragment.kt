package de.orome.ad340.details


import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import de.orome.ad340.ForecastUtils
import de.orome.ad340.TempDisplaySettingManager
import de.orome.ad340.databinding.FragmentForecastDetailsBinding

class ForecastDetailsFragment : Fragment() {

    private val args: ForecastDetailsFragmentArgs by navArgs()
    private lateinit var binding: FragmentForecastDetailsBinding
    private lateinit var tempDisplaySettingManager: TempDisplaySettingManager
    private val util = ForecastUtils()


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