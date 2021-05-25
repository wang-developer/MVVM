package com.main.mvvm.lifecycles

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent

class LifecycleManager( lifecycleOwner: LifecycleOwner) : LifecycleObserver {

    val TAG = "LifecycleManager"

    init {
        lifecycleOwner.lifecycle.addObserver(this)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun FunctionalOne(){

        Log.e(TAG,"FunctionalOne -> create -> " + System.currentTimeMillis())
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun FunctionalTwo(){
        Log.e(TAG,"FunctionalTwo -> start -> " + System.currentTimeMillis())
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun FunctionalThree(){
        Log.e(TAG,"FunctionalThree -> resume -> " + System.currentTimeMillis())
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun FunctionalFour(){
        Log.e(TAG,"FunctionalFour -> pause -> " + System.currentTimeMillis())
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun FunctionalFive(){
        Log.e(TAG,"FunctionalFive -> destroy -> " + System.currentTimeMillis())
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    fun FunctionalSix(){
        Log.e(TAG,"FunctionalSix -> any -> " + System.currentTimeMillis())
    }


}

