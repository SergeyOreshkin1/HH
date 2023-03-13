package com.lesson04.data.api_services

import com.lesson04.data.models.WeatherNetworkModel
import com.lesson04.utils.AppConstants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApiService {

    @GET(WEATHER)
    suspend fun getTemperatureByName(
        @Query("q") placeName: String
    ): Response<WeatherNetworkModel>

    @GET(WEATHER)
    suspend fun getTemperatureByCoordinates(
        @Query("lat") latitude: String,
        @Query("lon") longitude: String
    ): Response<WeatherNetworkModel>

    companion object {

        private const val WEATHER = "data/2.5/weather?&APPID=${AppConstants.API_KEY}"
    }
}
