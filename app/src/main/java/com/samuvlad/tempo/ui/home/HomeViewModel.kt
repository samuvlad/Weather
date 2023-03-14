package com.samuvlad.tempo.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.samuvlad.tempo.common.extensions.formatDate
import com.samuvlad.tempo.domain.base.Resource
import com.samuvlad.tempo.domain.model.Weather
import com.samuvlad.tempo.usecase.weather.GetCurrentWeatherUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val getCurrentWeatherUseCase: GetCurrentWeatherUseCase) : ViewModel() {

    private val _weather = MutableLiveData<Weather?>()
    val weather: LiveData<Weather?>  get() = _weather


    init {
        getCurrentWeather()
    }

    private fun getCurrentWeather(){
        viewModelScope.launch(Dispatchers.IO) {
            val response = when(val response = getCurrentWeatherUseCase.invoke(42.431, -8.64435, "", "metric", "gl")){
                is Resource.Success -> {
                    Log.d("Log", response.value.icon)
                    _weather.postValue(response.value)

                }
                else -> {}
            }

        }
    }
}