package com.example.omarsanchez.firstkotlin.data

import com.example.omarsanchez.firstkotlin.data.webservices.RetrofitApi


/**
 * Created by omarsanchez on 6/23/17.
 */
class DataProvider(private val onDataProvided: OnDataProvided) {

    fun getForecast(city: String, units: String, days: Int) {
        onDataProvided.forecastProvided(RetrofitApi().getForecast(city, units, days))
    }
}