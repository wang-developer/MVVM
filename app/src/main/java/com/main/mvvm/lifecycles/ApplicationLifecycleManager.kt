package com.main.mvvm.lifecycles

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.ProcessLifecycleOwner

class ApplicationLifecycleManager()  : LifecycleObserver {
    val TAG = this.javaClass.name
    init {
        ProcessLifecycleOwner.get().lifecycle.addObserver(this)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun FunctionalOne(){

        Log.e(TAG,"application -> create -> " + System.currentTimeMillis())
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun FunctionalTwo(){
        Log.e(TAG,"application -> start -> " + System.currentTimeMillis())
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun FunctionalThree(){
        Log.e(TAG,"application -> resume -> " + System.currentTimeMillis())
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun FunctionalFour(){
        Log.e(TAG,"application -> pause -> " + System.currentTimeMillis())
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun FunctionalFive(){
        Log.e(TAG,"application -> destroy -> " + System.currentTimeMillis())
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    fun FunctionalSix(){
        Log.e(TAG,"application -> any -> " + System.currentTimeMillis())
    }

}