package com.samuvlad.tempo.data.base

import com.samuvlad.tempo.domain.base.FailureError
import com.samuvlad.tempo.domain.base.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException

interface SafeApiCall {

    suspend fun <A, D> safeApiCall(mapper: Mapper<A, D>, apiCall: suspend() -> A): Resource<D> {
        return  withContext(Dispatchers.IO){
            try {
                val result = apiCall.invoke()
                val model = mapper.map(result)
                Resource.Success(model)
            }catch (throwable: Throwable){
                Resource.Failure(FailureError.Network)
            }
        }

    }

    private fun handle(throwable: Throwable): Resource.Failure {
        return when (throwable) {
            is HttpException -> {
                Resource.Failure(FailureError.Network)
            }

            else -> Resource.Failure(FailureError.Network)
        }
    }


}