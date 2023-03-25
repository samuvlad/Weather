package com.samuvlad.tempo.usecase.weather

import android.location.Location
import com.samuvlad.tempo.data.Repository
import com.samuvlad.tempo.domain.base.Resource
import com.samuvlad.tempo.domain.interfaces.IRepository
import com.samuvlad.tempo.domain.model.Weather
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetCurrentWeatherUseCase @Inject constructor(private val iRepository: IRepository) {

    suspend fun invoke(lat: Double, lon: Double, mode: String, units: String, lang: String): Resource<Weather>{
        return withContext(Dispatchers.IO){ iRepository.getCurrentWeather(lat, lon, mode, units, lang)}
    }
}