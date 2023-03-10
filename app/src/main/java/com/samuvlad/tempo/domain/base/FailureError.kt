package com.samuvlad.tempo.domain.base

sealed class FailureError{
    object Network: FailureError()
}
