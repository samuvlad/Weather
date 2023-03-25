package com.samuvlad.tempo.usecase.location

import com.samuvlad.tempo.domain.interfaces.IRepository
import javax.inject.Inject

class GetLocationInfoUserCase @Inject constructor(private val iRepository: IRepository) {
    
    suspend fun invoke(lat: Double, lon: Double) = iRepository.getLocationInfo(lat, lon)
}