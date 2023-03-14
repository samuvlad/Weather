package com.samuvlad.tempo.usecase.weather

import com.samuvlad.tempo.data.Repository
import com.samuvlad.tempo.domain.base.Resource
import com.samuvlad.tempo.domain.model.Weather
import javax.inject.Inject

class GetCurrentWeatherUseCase @Inject constructor(private val repository: Repository) {

    suspend fun invoke(lat: Double, lon: Double, mode: String, units: String, lang: String): Resource<Weather>{
        return repository.getCurrentWeather(lat, lon, mode, units, lang)
    }
}