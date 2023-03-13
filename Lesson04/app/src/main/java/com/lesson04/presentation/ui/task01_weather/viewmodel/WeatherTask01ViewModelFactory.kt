package com.lesson04.presentation.ui.task01_weather.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.lesson04.data.repositories.WeatherTask01Repository

class WeatherTask01ViewModelFactory constructor(private val repository: WeatherTask01Repository) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(WeatherTask01ViewModel::class.java)) {
            WeatherTask01ViewModel(this.repository) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}
