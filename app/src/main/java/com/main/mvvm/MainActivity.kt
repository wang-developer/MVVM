package com.main.mvvm

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.main.mvvm.dataStore.DataStoreActivity
import com.main.mvvm.lifecycles.LifecycleActivity
import com.main.mvvm.liveData.LiveDataActivity

class MainActivity : AppCompatActivity() {

    fun goTo(cls: Class<*>?){
        startActivity(Intent(this,cls))
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun startLiveData(v: View){
        goTo(LiveDataActivity::class.java)
    }

    fun startLifecycle(v: View){
        goTo(LifecycleActivity::class.java)
    }

    fun startDataStore(v: View){
        goTo(DataStoreActivity::class.java)
    }





}