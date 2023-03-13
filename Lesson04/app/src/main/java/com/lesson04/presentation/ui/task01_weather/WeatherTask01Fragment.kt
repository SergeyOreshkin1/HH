package com.lesson04.presentation.ui.task01_weather

import android.view.KeyEvent
import android.view.inputmethod.EditorInfo
import androidx.fragment.app.viewModels
import com.lesson04.R
import com.lesson04.data.api_services.RetrofitBuilder
import com.lesson04.data.api_services.WeatherApiService
import com.lesson04.data.repositories.WeatherTask01Repository
import com.lesson04.databinding.FragmentWeatherTask01Binding
import com.lesson04.presentation.ui.BaseFragment
import com.lesson04.presentation.ui.task01_weather.viewmodel.WeatherTask01ViewModel
import com.lesson04.presentation.ui.task01_weather.viewmodel.WeatherTask01ViewModelFactory
import com.lesson04.utils.AppConstants
import com.lesson04.utils.ScreenState
import com.lesson04.utils.TextPattern
import com.lesson04.utils.showToast

class WeatherTask01Fragment : BaseFragment<FragmentWeatherTask01Binding>(
    FragmentWeatherTask01Binding::inflate
) {

    private val apiService = RetrofitBuilder.getInstance().create(WeatherApiService::class.java)
    private val repository = WeatherTask01Repository(apiService)
    private val viewModel: WeatherTask01ViewModel by viewModels {
        WeatherTask01ViewModelFactory(
            repository
        )
    }

    private fun navigateToMainMenu() {
        binding.backBtn.setOnClickListener {
            parentFragmentManager.popBackStack()
        }
    }

    private fun getTemperatureByName() {
        viewModel.getTemperatureByName(binding.placeEditText.text.toString())
    }

    private fun getTemperatureByCoordinates() = with(binding) {
        viewModel.getTemperatureByCoordinates(
            placeEditText.text.toString()
                .split(AppConstants.SPACE_SEPARATOR)[AppConstants.STRING_FIRST_PART],
            placeEditText.text.toString()
                .split(AppConstants.SPACE_SEPARATOR)[AppConstants.STRING_SECOND_PART]
        )
    }

    private fun checkTemperatureBtnSetOnClickListener() {
        binding.checkTemperatureBtn.setOnClickListener {
            checkTemperature()
        }
    }

    private fun checkTemperature() = with(binding) {
        if (TextPattern.PLACE_NAME.pattern.matcher(placeEditText.text.toString())
                .matches()
        ) {
            getTemperatureByName()
        } else if (TextPattern.MAP_COORDINATES.pattern.matcher(placeEditText.text.toString())
                .matches()
        ) {
            getTemperatureByCoordinates()
        } else {
            showToast(resources.getString(R.string.error))
        }
    }

    private fun placeEditTextSetOnEditorActionListener() {
        binding.placeEditText.setOnEditorActionListener { _, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_DONE ||
                event.action == KeyEvent.ACTION_DOWN &&
                event.keyCode == KeyEvent.KEYCODE_ENTER
            ) {
                checkTemperature()
                true
            } else {
                false
            }
        }
    }

    private fun observeViewModelScreenState() {
        viewModel.screenState.observe(viewLifecycleOwner) { state ->
            when (state) {
                is ScreenState.Success -> {
                    binding.tempResult.text =
                        String.format(resources.getString(R.string.temp_result), state.data)
                }
                is ScreenState.Error -> {
                    showToast(state.responseErrorMessage.toString())
                }
            }
        }
    }

    override fun initializeFragment() {
        observeViewModelScreenState()
        navigateToMainMenu()
        checkTemperatureBtnSetOnClickListener()
        placeEditTextSetOnEditorActionListener()
    }
}
