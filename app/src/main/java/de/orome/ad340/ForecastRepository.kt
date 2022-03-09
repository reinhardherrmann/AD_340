package de.orome.ad340

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlin.random.Random

class ForecastRepository {

    private val _weeklyForecast = MutableLiveData<List<DailyForecast>>()
    val weeklyForacast: LiveData<List<DailyForecast>> = _weeklyForecast

    fun loadForecast(zipCode: String){
        // Zufallsliste mit 7 zufällig erzeugten Werten zwischen 0 und 100 erstellen
        val randomValues = List(7) { Random.nextFloat().rem(100) * 100 }
        val forecastItems = randomValues.map { temp ->
            DailyForecast(temp, getTempDescription(temp))

        }
        // Livedata aktualisieren
        _weeklyForecast.setValue(forecastItems)
    }

    fun getTempDescription(temp: Float): String{
        return when (temp) {
            in Float.MIN_VALUE.rangeTo(0f) -> "Anything below 0 doesn't make sense"
            else -> {"Bla"}
        }
    }
}