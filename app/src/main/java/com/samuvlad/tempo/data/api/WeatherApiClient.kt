package com.samuvlad.tempo.data.api

import com.samuvlad.tempo.data.api.model.WeatherApi
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApiClient {

    @GET("")
    suspend fun getCurrentWeather(@Query("appid") token: String,
                                  @Query("lat") lat: String,
                                  @Query("lon") lon: String,
                                  @Query("mode") mode: String,
                                  @Query("units") units: String,
                                  @Query("lang") lang: String): WeatherApi

}