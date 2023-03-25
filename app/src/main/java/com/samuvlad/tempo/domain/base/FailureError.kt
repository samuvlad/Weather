package com.samuvlad.tempo.domain.base

sealed class FailureError{
    object Network: FailureError()
    object Unknown: FailureError()

    object BadRequest: FailureError()
}
