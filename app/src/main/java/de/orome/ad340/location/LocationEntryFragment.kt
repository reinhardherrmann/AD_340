package de.orome.ad340.location

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import de.orome.ad340.*

class LocationEntryFragment : Fragment() {


    private lateinit var appNavigator: AppNavigator

    override fun onAttach(context: Context) {
        super.onAttach(context)
        appNavigator = context as AppNavigator
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_location_entry, container, false)

        //

        var et_ZipCode: EditText = view.findViewById(R.id.et_PLZ)
        val btnEnter: Button = view.findViewById(R.id.btn_submit_zip_code)

        var zipCode:String = ""

        btnEnter.setOnClickListener{
            zipCode = et_ZipCode.text.toString()
            if (zipCode.length < 5){
                Toast.makeText(this.requireContext(), getString(R.string.err_msg_zip_code), Toast.LENGTH_SHORT).show()
            } else{
                 appNavigator.navigateToCurrentForecast(zipCode)
                //Toast.makeText(this.requireContext(),"PLZ: ${et_ZipCode.text.toString()}",Toast.LENGTH_SHORT).show()
            }
        }

        // Inflate the layout for this fragment
        return view



    }





}