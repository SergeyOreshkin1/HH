package com.lesson04.data.models

import com.squareup.moshi.Json

data class WeatherNetworkModel(
    @Json(name = "main") val temperature: TemperatureDto
)
