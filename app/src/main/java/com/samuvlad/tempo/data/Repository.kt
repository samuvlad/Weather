package com.samuvlad.tempo.data

import com.samuvlad.tempo.data.api.WeatherApiClient
import com.samuvlad.tempo.data.base.BaseApiClient
import com.samuvlad.tempo.data.base.SafeApiCall
import com.samuvlad.tempo.domain.base.Resource
import com.samuvlad.tempo.domain.model.Weather
import javax.inject.Inject

class Repository @Inject constructor(private val weatherApiClient: WeatherApiClient): BaseApiClient() {

    suspend fun getCurrentWeather(token: String, lat: String, lon: String, mode: String, units: String, lang: String): Resource<Weather> = safeApiCall(WeatherMapper()) {
        weatherApiClient.getCurrentWeather(token, lat, lon, mode, units, lang)
    }
}