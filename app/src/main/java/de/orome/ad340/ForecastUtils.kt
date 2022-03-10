package de.orome.ad340

class ForecastUtils {
    fun formatTempForDisplay(temp: Float): String {
        // TODO with defining Fahrenheit or  Celsius add the format unit
        return String.format("%.2f°", temp)
    }
}