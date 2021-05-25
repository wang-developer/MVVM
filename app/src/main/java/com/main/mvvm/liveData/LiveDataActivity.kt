package com.main.mvvm.liveData

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.main.mvvm.R
import com.main.mvvm.databinding.ActivityLiveDataBinding

class LiveDataActivity : AppCompatActivity() {


    private val viewModel: LiveDataViewModel by viewModels { LiveDataVMFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityLiveDataBinding>(this,R.layout.activity_live_data)

        binding.lifecycleOwner = this

        binding.viewmodel = viewModel
    }

}