package com.samuvlad.tempo.domain.interfaces

import android.location.Location
import com.samuvlad.tempo.domain.base.Resource
import com.samuvlad.tempo.domain.model.LocationInfo
import com.samuvlad.tempo.domain.model.Weather
import javax.xml.transform.dom.DOMLocator

interface IRepository {

   suspend fun getCurrentWeather(lat: Double, lon: Double, mode: String, units: String, lang: String): Resource<Weather>

   suspend fun getLocation(callback: (Resource<Location>) -> Unit)

   suspend fun getLocationInfo(lat: Double, lon: Double): Resource<LocationInfo>
}