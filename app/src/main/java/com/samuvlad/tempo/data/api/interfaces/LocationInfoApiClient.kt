package com.samuvlad.tempo.data.api.interfaces

import com.samuvlad.tempo.data.api.model.locationinfo.LocationInfoApi
import retrofit2.http.GET
import retrofit2.http.Query

interface LocationInfoApiClient {

    @GET("/data/reverse-geocode-client")
    suspend fun getLocationInfo(@Query("latitude") latitude: Double,
                                @Query("longitude") longitude: Double,
                                @Query("localityLanguage") localityLanguage: String): LocationInfoApi
}