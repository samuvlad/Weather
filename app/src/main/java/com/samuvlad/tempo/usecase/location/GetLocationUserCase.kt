package com.samuvlad.tempo.usecase.location

import android.location.Location
import com.samuvlad.tempo.domain.base.Resource
import com.samuvlad.tempo.domain.interfaces.IRepository
import javax.inject.Inject

class GetLocationUserCase @Inject constructor(private val iRepository: IRepository) {

    suspend fun invoke(callback: (Resource<Location>) -> Unit) = iRepository.getLocation{callback(it)}
}