package com.samuvlad.tempo.data.base

interface Mapper<A, D> {
    fun map(mode: A): D
}