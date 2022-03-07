package de.orome.ad340

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        var et_ZipCode: EditText = findViewById(R.id.et_PLZ)
        val btnEnter: Button = findViewById(R.id.btn_submit_zip_code)
        var zipCode:String = ""

        btnEnter.setOnClickListener{
            zipCode = et_ZipCode.text.toString()
            if (zipCode.length < 5){
                Toast.makeText(this, getString(R.string.err_msg_zip_code), Toast.LENGTH_SHORT).show()
            } else{
                Toast.makeText(this,"PLZ: ${et_ZipCode.text.toString()}",Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.w("MyTag", "onStart aufgerufen")
    }

    override fun onResume() {
        super.onResume()
        Log.w("MyTag", "onResume aufgerufen")
    }

    override fun onPause() {
        super.onPause()
        Log.w("MyTag", "onPause aufgerufen")
    }

    override fun onStop() {
        super.onStop()
        Log.w("MyTag", "onStop aufgerufen")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.w("MyTag", "onDestroy aufgerufen")
    }

}