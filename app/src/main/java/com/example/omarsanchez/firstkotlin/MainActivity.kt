package com.example.omarsanchez.firstkotlin


import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.omarsanchez.firstkotlin.adapters.ForecastAdapter
import com.example.omarsanchez.firstkotlin.data.DataProvider
import com.example.omarsanchez.firstkotlin.data.OnDataProvided
import com.example.omarsanchez.firstkotlin.data.models.Forecast
import io.reactivex.Observable


class MainActivity : AppCompatActivity(), OnDataProvided {


    val dataProvider: DataProvider by lazy { DataProvider(this) }
    val adapter: ForecastAdapter by lazy { ForecastAdapter(mutableListOf()) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        dataProvider.getForecast("guadalajara", "metric", 7)
        val list = findViewById(R.id.main_recycler) as RecyclerView
        list.adapter = adapter
        list.setHasFixedSize(true)
        list.layoutManager = LinearLayoutManager(this)


    }

    override fun forecastProvided(forecasts: Observable<Forecast>) {
        forecasts.doOnNext {
            result(it)
        }
                .doOnError {
                    it.printStackTrace()
                }
                .doOnComplete {

                }
                .subscribe()
    }

    fun result(forecast: Forecast) {
        adapter.items = forecast.list
        adapter.notifyDataSetChanged()
    }

}


