package com.main.mvvm.liveData

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.liveData
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class DefaultDataSource(private val ioDispatcher: CoroutineDispatcher):DataSource {
    override fun getCurrentTime(): LiveData<Long> =
        liveData {
            while (true){
                emit(System.currentTimeMillis())
                kotlinx.coroutines.delay(1000)
            }
        }


    private val weatherConditions = listOf("Sunny", "Cloudy", "Rainy", "Stormy", "Snowy")
    override fun fetchWeather(): LiveData<String> = liveData {
        var counter = 0
        while (true) {
            counter++
            delay(2000)

            emit(weatherConditions[counter % weatherConditions.size])
        }
    }

    private val _cachedData = MutableLiveData("This is old data")
    override val cachedData: LiveData<String> = _cachedData


    override suspend fun fetchNewData() {
        withContext(Dispatchers.Main) {
            _cachedData.value = "Fetching new data..."
            _cachedData.value = simulateNetworkDataFetch()
        }
    }

    private var counter = 0
    // Using ioDispatcher because the function simulates a long and expensive operation.
    private suspend fun simulateNetworkDataFetch(): String = withContext(ioDispatcher) {
        delay(3000)
        counter++
        "New data from request #$counter"
    }

}

interface DataSource{
    fun getCurrentTime():LiveData<Long>
    fun fetchWeather():LiveData<String>
    val cachedData: LiveData<String>
    suspend fun fetchNewData()
}