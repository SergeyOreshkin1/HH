package com.lesson04.domain.model

import com.lesson04.data.models.TemperatureDto
import com.squareup.moshi.Json

data class WeatherDomainModel(
    @Json(name = "main") val temperature: TemperatureDto
)
