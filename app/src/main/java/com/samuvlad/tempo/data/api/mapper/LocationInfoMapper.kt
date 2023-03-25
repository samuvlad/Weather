package com.samuvlad.tempo.data.api.mapper

import com.samuvlad.tempo.data.api.model.locationinfo.LocationInfoApi
import com.samuvlad.tempo.data.base.Mapper
import com.samuvlad.tempo.domain.model.LocationInfo

class LocationInfoMapper: Mapper<LocationInfoApi, LocationInfo> {
    override fun map(mode: LocationInfoApi): LocationInfo {
        return LocationInfo(locality = mode.locality)
    }
}