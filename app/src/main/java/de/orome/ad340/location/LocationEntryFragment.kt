package de.orome.ad340.location

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import de.orome.ad340.R
import de.orome.ad340.databinding.FragmentLocationEntryBinding
import de.orome.ad340.interfaces.AppNavigator


class LocationEntryFragment : Fragment() {

    private lateinit var binding: FragmentLocationEntryBinding
    private lateinit var appNavigator: AppNavigator

    /**
     * hier wird der Appnavigator, von dem Mainactivity erbt, referenziert über Context
     * Context kommt von MainActivity und wird hier als appNavigator gecastet
     */
    override fun onAttach(context: Context) {
        super.onAttach(context)
        /**
         * appNavigator initialisieren -> Funktionen aus Interface stehen im Fragment
         * -> Methoden aus AppNavigator stehen zur Verfügung
         */
        appNavigator = context as AppNavigator
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLocationEntryBinding.inflate(inflater, container,false)
        val view: View = binding.root


        var zipCode:String = ""

        binding.apply {
            btnSubmitZipCode.setOnClickListener {
                zipCode = etPLZ.text.toString()
                if (zipCode.length < 5) {
                    Toast.makeText(requireContext(), getString(R.string.err_msg_zip_code), Toast.LENGTH_SHORT)
                        .show()
                } else {
                    appNavigator.navigateToCurrentForecast(zipCode)
//                    Toast.makeText(requireContext(),"PLZ: ${etPLZ.text.toString()}",Toast.LENGTH_SHORT).show()
                }
            }
        }





        return view
    }

}