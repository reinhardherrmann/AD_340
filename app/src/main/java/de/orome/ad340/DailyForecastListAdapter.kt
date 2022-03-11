package de.orome.ad340

import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class DailyForecastViewHolder(
    view: View,
    private val tempDisplaySettingManager: TempDisplaySettingManager)
    : RecyclerView.ViewHolder(view){


    private val tempText = view.findViewById<TextView>(R.id.tv_item_temperature)
    private val descriptionText: TextView = view.findViewById(R.id.tv_item_description)
    private val util = ForecastUtils()

    // views mit Werten füllen
    fun bind(dailyForecast: DailyForecast){
        tempText.text = util.formatTempForDisplay(dailyForecast.temperature, tempDisplaySettingManager.getTempDisplaySetting())
        descriptionText.text = dailyForecast.description.toString()
    }
}

class DailyForecastListAdapter(
    private val tempDisplaySettingManager: TempDisplaySettingManager,
    private val clickHandler: (DailyForecast) -> Unit
): ListAdapter<DailyForecast, DailyForecastViewHolder>(DIFF_CONFIG) {


    companion object {
        // hier genau diesen Inhalt einsetzen!!!!
        val DIFF_CONFIG = object: DiffUtil.ItemCallback<DailyForecast>(){
            override fun areItemsTheSame(oldItem: DailyForecast, newItem: DailyForecast): Boolean {
                return oldItem === newItem
            }

            override fun areContentsTheSame(
                oldItem: DailyForecast,
                newItem: DailyForecast
            ): Boolean {
                return oldItem == newItem
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DailyForecastViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_daily_forecast,parent,false)
        return DailyForecastViewHolder(itemView, tempDisplaySettingManager)
    }

    override fun onBindViewHolder(holder: DailyForecastViewHolder, position: Int) {
        holder.bind(getItem(position))
        holder.itemView.setOnClickListener{
            clickHandler(getItem(position))
        }
    }
}