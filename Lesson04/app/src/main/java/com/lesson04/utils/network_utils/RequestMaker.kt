package com.lesson04.utils.network_utils

import retrofit2.HttpException
import retrofit2.Response

class RequestMaker {

    suspend fun <Data : Any, Domain : Any> handleApi(
        execute: suspend () -> Response<Data>,
        mapResponse: (Data) -> Domain,
    ): NetworkResult<Domain> {
        return try {
            val response = execute()
            val body = response.body()
            if (response.isSuccessful && body != null) {
                NetworkResult.Success(mapResponse(body))
            } else {
                NetworkResult.Error(code = response.code(), message = response.message())
            }
        } catch (e: HttpException) {
            NetworkResult.Error(code = e.code(), message = e.message())
        } catch (e: Throwable) {
            NetworkResult.Exception(e)
        }
    }
}