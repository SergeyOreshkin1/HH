package com.lesson04.data.mapper

import com.lesson04.data.models.WeatherNetworkModel
import com.lesson04.domain.model.WeatherDomainModel
import com.lesson04.utils.network_utils.Mapper

class WeatherTask01Mapper :
    Mapper<WeatherNetworkModel, WeatherDomainModel> {

    override fun map(input: WeatherNetworkModel): WeatherDomainModel =
        WeatherDomainModel(input.temperature)
}
