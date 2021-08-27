package com.hixtrik.weatherapp

import android.content.Context

class Datasource(val context: Context) {
    fun getWeatherList(): Array<String> {
        return context.resources.getStringArray(R.array.weather_array)
    }

    fun getClockList(): Array<String> {
        return context.resources.getStringArray(R.array.clock_array)
    }
}