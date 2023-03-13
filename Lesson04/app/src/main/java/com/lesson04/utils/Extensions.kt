package com.lesson04.utils

import android.widget.Toast
import androidx.fragment.app.Fragment

private const val KELVIN_CONST = 273

fun Double.toCelcius(): Int {
    return this.toInt() - KELVIN_CONST
}

fun Fragment.showToast(message: String) {
    Toast.makeText(requireContext(), message, Toast.LENGTH_LONG).show()
}
