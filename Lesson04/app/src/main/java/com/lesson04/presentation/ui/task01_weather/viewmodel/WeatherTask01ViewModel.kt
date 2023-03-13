package com.lesson04.presentation.ui.task01_weather.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lesson04.data.repositories.WeatherTask01Repository
import com.lesson04.utils.ScreenState
import com.lesson04.utils.network_utils.NetworkResult
import com.lesson04.utils.toCelcius
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WeatherTask01ViewModel(
    private val repository: WeatherTask01Repository
) : ViewModel() {

    private var _screenState = MutableLiveData<ScreenState<Int>>()
    val screenState get() : LiveData<ScreenState<Int>> = _screenState

    fun getTemperatureByName(placeName: String) {
        viewModelScope.launch(Dispatchers.IO) {
            when (val result = repository.getTemperatureByName(placeName)) {
                is NetworkResult.Success -> _screenState.postValue(ScreenState.Success(result.data.temperature.temp.toCelcius()))
                is NetworkResult.Error -> _screenState.postValue(ScreenState.Error(result.message))
                is NetworkResult.Exception -> _screenState.postValue(ScreenState.Error(result.e.toString()))
            }
        }
    }

    fun getTemperatureByCoordinates(lat: String, lon: String) {
        viewModelScope.launch(Dispatchers.IO) {
            when (val result = repository.getTemperatureByCoordinates(lat, lon)) {
                is NetworkResult.Success -> _screenState.postValue(ScreenState.Success(result.data.temperature.temp.toCelcius()))
                is NetworkResult.Error -> _screenState.postValue(ScreenState.Error(result.message))
                is NetworkResult.Exception -> _screenState.postValue(ScreenState.Error(result.e.toString()))
            }
        }
    }
}
