package de.orome.ad340.interfaces
import de.orome.ad340.DailyForecast

interface AppNavigator {
      fun navigateToCurrentForecast(zipCode: String)
      fun navigateToLocationEntry()
      fun navigateToForecastDetails(forecast: DailyForecast)
}