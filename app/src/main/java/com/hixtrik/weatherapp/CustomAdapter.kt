package com.hixtrik.weatherapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlin.random.Random

//┌──────────────────────────┐
//│ Created by Taha ARICAN   │
//│ aricantaha06@gmail.com   │            
//│ 26.08.2021               │
//└──────────────────────────┘

class CustomAdapter(val weatherList: Array<String>, val clockList: Array<String>) :
    RecyclerView.Adapter<CustomAdapter.WeatherViewHolder>() {

    class WeatherViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val degreeTextView: TextView = itemView.findViewById(R.id.tv_degree2)
        private val clockTextView: TextView = itemView.findViewById(R.id.tv_clock)
        private val weatherImage: ImageView = itemView.findViewById(R.id.iv_icon2)

        fun bind(degree: String, clock: String) {
            degreeTextView.text = degree
            clockTextView.text = clock
            weatherImage.setImageResource(
                when (Random.nextInt(1, 8)) {
                    1 -> R.drawable.snow
                    2 -> R.drawable.cloud
                    3 -> R.drawable.cloud_cloud
                    4 -> R.drawable.cloud_sun
                    5 -> R.drawable.rain
                    6 -> R.drawable.sun
                    7 -> R.drawable.thunderstorm
                    else -> R.drawable.sun
                }
            )
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item, parent, false)

        return WeatherViewHolder(view)
    }

    override fun getItemCount(): Int {
        return weatherList.size
    }

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        holder.bind(weatherList[position], clockList[position])
    }
}
