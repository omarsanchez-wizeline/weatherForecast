package com.example.omarsanchez.firstkotlin.data

import com.example.omarsanchez.firstkotlin.data.models.Forecast
import io.reactivex.Observable

/**
 * Created by omarsanchez on 6/23/17.
 */
interface OnDataProvided {
    fun forecastProvided(forecasts : Observable<Forecast>)
}