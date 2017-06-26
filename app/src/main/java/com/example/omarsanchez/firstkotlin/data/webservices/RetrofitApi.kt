package com.example.omarsanchez.firstkotlin.data.webservices

import com.example.omarsanchez.firstkotlin.BuildConfig.API_KEY
import com.example.omarsanchez.firstkotlin.BuildConfig.BASE_URL
import com.example.omarsanchez.firstkotlin.data.models.Forecast
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/**
 * Created by omarsanchez on 6/22/17.
 */
class RetrofitApi {
    fun getForecast(place: String, units: String, days: Int): Observable<Forecast> {
        return api.getForecast(place, units, days, API_KEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }

    private val api: Services by lazy {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(logging)

        Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(httpClient.build())
                .build().create(Services::class.java)
    }
}