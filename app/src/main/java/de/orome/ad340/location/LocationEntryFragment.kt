package de.orome.ad340.location

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import de.orome.ad340.R
import de.orome.ad340.databinding.FragmentLocationEntryBinding


class LocationEntryFragment : Fragment() {

    private lateinit var binding: FragmentLocationEntryBinding


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
                    findNavController().navigateUp()
                }
            }
        }





        return view
    }

}