package com.lesson04.utils

sealed class ScreenState<out T> {
    data class Success<out T>(val data: T) : ScreenState<T>()
    data class Error(val responseErrorMessage: String?) : ScreenState<Nothing>()
}
