package com.example.omarsanchez.firstkotlin.data.models

/**
 * Created by omarsanchez on 6/23/17.
 */
data class Forecast(
        val city: City,
        val cod: String,
        val count: Int,
        val list: List<Day>
)