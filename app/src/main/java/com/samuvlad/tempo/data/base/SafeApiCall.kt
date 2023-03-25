package com.samuvlad.tempo.data.base

import android.util.Log
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
                Log.e("Error REST Service", throwable.message.toString())
                handle(throwable)
            }
        }

    }

    private fun handle(throwable: Throwable): Resource.Failure {
        return when (throwable) {
            is HttpException -> {
                Resource.Failure(codeError(throwable.code()))
            }
            else -> Resource.Failure(FailureError.Network)
        }
    }

    private fun codeError(codeError: Int): FailureError{
        return when(codeError){
            400 -> FailureError.BadRequest
            else -> FailureError.Unknown
        }
    }


}