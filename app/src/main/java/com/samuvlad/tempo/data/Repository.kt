package com.samuvlad.tempo.data

import android.location.Location
import android.util.Log
import com.samuvlad.tempo.BuildConfig
import com.samuvlad.tempo.data.api.interfaces.LocationInfoApiClient
import com.samuvlad.tempo.data.api.interfaces.WeatherApiClient
import com.samuvlad.tempo.data.api.mapper.LocationInfoMapper
import com.samuvlad.tempo.data.api.mapper.WeatherApiMapper
import com.samuvlad.tempo.data.base.BaseApiClient
import com.samuvlad.tempo.data.service.LocationService
import com.samuvlad.tempo.domain.base.FailureError
import com.samuvlad.tempo.domain.base.Resource
import com.samuvlad.tempo.domain.interfaces.IRepository
import com.samuvlad.tempo.domain.model.LocationInfo
import com.samuvlad.tempo.domain.model.Weather
import javax.inject.Inject

class Repository @Inject constructor(private val weatherApiClient: WeatherApiClient, private val locationService: LocationService, private val locationInfoApiClient: LocationInfoApiClient) : BaseApiClient(), IRepository {

    override suspend fun getCurrentWeather(lat: Double, lon: Double, mode: String, units: String, lang: String): Resource<Weather> = safeApiCall(WeatherApiMapper()) {
        weatherApiClient.getCurrentWeather(BuildConfig.WeatherAPIKeyProp, lat, lon, mode, units, lang)
    }

    override suspend fun getLocation(callback: (Resource<Location>) -> Unit) {
        locationService.getLocation {
            it?.let {
                callback(Resource.Success(it))
            }.run {
                Log.e("Error Repository", "Error get Location")
                callback(Resource.Failure(FailureError.Unknown)) }
        }
    }

    override suspend fun getLocationInfo(lat: Double, lon: Double): Resource<LocationInfo> = safeApiCall(LocationInfoMapper()){
       locationInfoApiClient.getLocationInfo(lat, lon, "es")
    }


}