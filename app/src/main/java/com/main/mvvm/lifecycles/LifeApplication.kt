package com.main.mvvm.lifecycles

import android.app.Activity
import android.app.Application
import android.os.Bundle

class LifeApplication : Application(), Application.ActivityLifecycleCallbacks {

    override fun onCreate() {
        super.onCreate()

        registerActivityLifecycleCallbacks(this)


        ApplicationLifecycleManager()

    }





    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
//        TODO("Not yet implemented")
    }

    override fun onActivityStarted(activity: Activity) {
//        TODO("Not yet implemented")
    }

    override fun onActivityResumed(activity: Activity) {
//        TODO("Not yet implemented")
    }

    override fun onActivityPaused(activity: Activity) {
//        TODO("Not yet implemented")
    }

    override fun onActivityStopped(activity: Activity) {
//        TODO("Not yet implemented")
    }

    override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {
//        TODO("Not yet implemented")
    }

    override fun onActivityDestroyed(activity: Activity) {
//        TODO("Not yet implemented")
    }

}