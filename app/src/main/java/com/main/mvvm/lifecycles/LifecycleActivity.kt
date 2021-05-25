package com.main.mvvm.lifecycles

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import com.main.mvvm.R
import com.main.mvvm.databinding.ActivityLiveDataBinding

class LifecycleActivity : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_lifecycles)

        LifecycleManager(this)

    }

}