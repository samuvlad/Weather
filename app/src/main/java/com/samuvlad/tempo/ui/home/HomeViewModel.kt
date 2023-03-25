package com.samuvlad.tempo.ui.home

import android.location.Location
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.samuvlad.tempo.domain.base.Resource
import com.samuvlad.tempo.domain.model.LocationInfo
import com.samuvlad.tempo.domain.model.Weather
import com.samuvlad.tempo.usecase.location.GetLocationInfoUserCase
import com.samuvlad.tempo.usecase.weather.GetCurrentWeatherUseCase
import com.samuvlad.tempo.usecase.location.GetLocationUserCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val getCurrentWeatherUseCase: GetCurrentWeatherUseCase, private val getLocationUserCase: GetLocationUserCase, private val getLocationInfoUserCase: GetLocationInfoUserCase) : ViewModel() {

    private val _weather = MutableLiveData<Weather?>()
    val weather: LiveData<Weather?>  get() = _weather

    private val _location = MutableLiveData<LocationInfo?>()
    val locationInfo: LiveData<LocationInfo?> get() = _location

    private val channel = Channel<Weather>(Channel.BUFFERED)
    val eventFlow = channel.receiveAsFlow()


    private fun getCurrentWeather(location: Location){
        viewModelScope.launch(Dispatchers.IO) {
            when(val response = getCurrentWeatherUseCase.invoke(location.latitude, location.longitude, "", "metric", "gl")){
                is Resource.Success -> {
                    _weather.postValue(response.value)
                    channel.send(response.value)

                }
                else -> {}
            }
        }
    }

    private fun getLocationInfo(location: Location){
        viewModelScope.launch(Dispatchers.IO) {
            when(val response = getLocationInfoUserCase.invoke(location.latitude, location.longitude)){
                is Resource.Success ->{
                    _location.postValue(response.value)
                }
                else -> {}
            }
        }
    }

    fun getLocation(){
        viewModelScope.launch(Dispatchers.IO) {
            getLocationUserCase.invoke{
                when(it){
                    is Resource.Success -> {
                        getCurrentWeather(it.value)
                        getLocationInfo(it.value)
                    }
                    is Resource.Failure -> {}

                }
            }
        }
    }
}