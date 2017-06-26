package com.example.omarsanchez.firstkotlin.data.webservices

import com.example.omarsanchez.firstkotlin.data.models.Forecast
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by omarsanchez on 6/23/17.
 */
internal interface Services {
    @GET("daily")
    fun getForecast(@Query("q")place:String, @Query("units")unit: String, @Query("cnt")days:Int, @Query("appid")apiKey:String):Observable<Forecast>

}