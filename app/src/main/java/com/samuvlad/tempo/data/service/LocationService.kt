package com.samuvlad.tempo.data.service

import android.annotation.SuppressLint
import android.content.Context
import android.location.Location
import android.util.Log

import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import javax.inject.Inject

class LocationService @Inject constructor(var context: Context)  {

    private lateinit var fusedLocationClient: FusedLocationProviderClient

    @SuppressLint("MissingPermission")
    fun getLocation(callback: (Location?) -> Unit) {
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(context)
        fusedLocationClient.lastLocation
            .addOnSuccessListener { location : Location? ->
                callback(location)
            }
            .addOnFailureListener { it.message  }

    }



}