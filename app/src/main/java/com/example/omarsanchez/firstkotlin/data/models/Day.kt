package com.example.omarsanchez.firstkotlin.data.models

/**
 * Created by omarsanchez on 6/23/17.
 */
data class Day(
        val dt : Int,
        val temp: Temp,
        val weather: List<Weather>
){
    fun getDate(): String {
        return dt.toString()
    }

    fun getWeatherDescription(): String {
        return weather[0].description
    }

    fun getWeatherIcon() : String{
        return weather[0].icon
    }
}
