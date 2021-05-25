package com.main.mvvm.liveData

import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.*

class LiveDataViewModel (private val dataSource: DataSource): ViewModel() {

    val currentTime = dataSource.getCurrentTime()

    val currentTimeTransformed = currentTime.switchMap {
        liveData { emit(timeStampToTime(it)) }
    }

    val currentWeather:LiveData<String> = liveData {
        emit(LOADING_STRING)
        emitSource(dataSource.fetchWeather())
    }

    val cachedValue = dataSource.cachedData

    fun onRefresh(){
        viewModelScope.launch {
            dataSource.fetchNewData()
        }
    }

    private suspend fun timeStampToTime(timestamp:Long):String{
        delay(500) //延迟500毫秒
        return Date(timestamp).toString() //返回当前时间
    }

    companion object{
        const val LOADING_STRING = "Loading..."
    }
}

object LiveDataVMFactory : ViewModelProvider.Factory{

    private val dataSource = DefaultDataSource(Dispatchers.IO)

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return LiveDataViewModel(dataSource) as T
    }

}