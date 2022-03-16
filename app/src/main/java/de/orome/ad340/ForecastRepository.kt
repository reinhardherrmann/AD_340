package de.orome.ad340

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlin.random.Random

class ForecastRepository {

    private val _weeklyForecast = MutableLiveData<List<DailyForecast>>()
    val weeklyForecast: LiveData<List<DailyForecast>> = _weeklyForecast

    fun loadForecast(zipCode: String){
        // Zufallsliste mit 7 zufällig erzeugten Werten zwischen 0 und 100 erstellen
        val randomValues = List(10) { Random.nextFloat().rem(100) * 100 }
        val forecastItems = randomValues.map { temp ->
            DailyForecast(temp, getTempDescription(temp))

        }
        // Livedata aktualisieren
        _weeklyForecast.setValue(forecastItems)
    }

    fun getTempDescription(temp: Float): String{
        return when (temp) {
            in Float.MIN_VALUE.rangeTo(0f) -> "Anything below 0 doesn't make sense"
            in 0f.rangeTo(55f) ->"Way too cold"
            in 55f.rangeTo(65f) ->"Colder than i would prefer"
            in 65f.rangeTo(80f) ->"Getting better"
            in 80f.rangeTo(90f) ->"That's the sweet spot!"
            in 90f.rangeTo(100f) ->"Getting a little warm"
            in 100f.rangeTo(Float.MAX_VALUE) ->"Waht is this, Arizona?"
            else -> "Does not compute"
        }
    }
}