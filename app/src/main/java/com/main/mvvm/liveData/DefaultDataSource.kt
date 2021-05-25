package com.main.mvvm.liveData

import androidx.lifecycle.LiveData

class DefaultDataSource {


}

interface DataSource{
    fun getCurrentTime():LiveData<Long>
    fun fetchWeather():LiveData<String>
    val cachedData: LiveData<String>
    suspend fun fetchNewData()
}