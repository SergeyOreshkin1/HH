package com.lesson04.data.repositories

import com.lesson04.data.api_services.WeatherApiService
import com.lesson04.data.mapper.WeatherTask01Mapper
import com.lesson04.domain.model.WeatherDomainModel
import com.lesson04.utils.network_utils.NetworkResult
import com.lesson04.utils.network_utils.RequestMaker

class WeatherTask01Repository(
    private val serviceApi: WeatherApiService,
) {

    private val mapper: WeatherTask01Mapper = WeatherTask01Mapper()
    private val requestMaker: RequestMaker = RequestMaker()

    suspend fun getTemperatureByName(placeName: String): NetworkResult<WeatherDomainModel> =
        requestMaker.handleApi(
            execute = { serviceApi.getTemperatureByName(placeName) },
            mapResponse = mapper::map
        )

    suspend fun getTemperatureByCoordinates(
        lat: String,
        lon: String
    ): NetworkResult<WeatherDomainModel> =
        requestMaker.handleApi(
            execute = { serviceApi.getTemperatureByCoordinates(lat, lon) },
            mapResponse = mapper::map
        )
}
