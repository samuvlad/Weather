package com.samuvlad.tempo.data.api.interfaces

import com.samuvlad.tempo.data.api.model.weather.WeatherApi
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApiClient {

    @GET("weather")
    suspend fun getCurrentWeather(@Query("appid") token: String,
                                  @Query("lat") lat: Double,
                                  @Query("lon") lon: Double,
                                  @Query("mode") mode: String,
                                  @Query("units") units: String,
                                  @Query("lang") lang: String): WeatherApi

}