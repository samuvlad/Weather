package com.samuvlad.tempo.data

import com.samuvlad.tempo.BuildConfig
import com.samuvlad.tempo.data.api.WeatherApiClient
import com.samuvlad.tempo.data.base.BaseApiClient
import com.samuvlad.tempo.data.api.mapper.WeatherApiMapper
import com.samuvlad.tempo.domain.base.Resource
import com.samuvlad.tempo.domain.model.Weather
import javax.inject.Inject

class Repository @Inject constructor(private val weatherApiClient: WeatherApiClient): BaseApiClient() {

    suspend fun getCurrentWeather(lat: Double, lon: Double, mode: String, units: String, lang: String): Resource<Weather> = safeApiCall(
        WeatherApiMapper()
    ) {
        weatherApiClient.getCurrentWeather(BuildConfig.WeatherAPIKeyProp, lat, lon, mode, units, lang)
    }
}