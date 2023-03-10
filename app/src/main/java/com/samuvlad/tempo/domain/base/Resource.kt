package com.samuvlad.tempo.domain.base

sealed class Resource<out D>{
    data class Success<out D>(val value: D): Resource<D>()
    data class Failure(val type: FailureError, val message: String? = ""): Resource<Nothing>()
}
