package de.orome.ad340

import android.content.Context
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class ForecastUtils {

    /**
     * Funktion gibt Temperatur mit 2 Dezimalstellen aus
     */
    fun formatTempForDisplay(temp: Float, tempDisplaySetting: TempDisplaySetting): String {
        // TODO with defining Fahrenheit or  Celsius add the format unit
        return when(tempDisplaySetting){
            TempDisplaySetting.Fahrenheit -> return String.format("%.2f °F", temp)
            TempDisplaySetting.Celsius -> {
                // Temperatur umwandeln
                val temp = (temp - 32f) * (5f / 9f)
                return String.format("%.2f °C", temp)
            }
        }
    }

    fun showTempDisplaySettingDialog(context: Context, tempDisplaySettingManager: TempDisplaySettingManager) {
        val dialogBuilder = AlertDialog.Builder(context)
            .setTitle("Select Unit")
            .setMessage("choose which temperature unit will be displayed.")
            .setPositiveButton("°F") { _, _ ->
                tempDisplaySettingManager.updateSettings(TempDisplaySetting.Fahrenheit)
            }
            .setNeutralButton("°C") { _, _ ->
                tempDisplaySettingManager.updateSettings(TempDisplaySetting.Celsius)
            }
            // wird immer angezeigt
            .setOnDismissListener {
                Toast.makeText(context, "Setting will take affect on app restart", Toast.LENGTH_SHORT)
                    .show()
                //tempDisplaySettingManager.updateSettings(TempDisplaySetting.Celsius)
            }
        dialogBuilder.show()
    }
}