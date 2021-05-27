package com.main.mvvm.dataStore

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.SharedPreferencesMigration
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import com.main.mvvm.R
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException

//基本创建的方法
private val Context.dataStore by preferencesDataStore("fileName")


//从以前的SharedPreferences中迁移
//private val Context.dataStore by preferencesDataStore("fileName",produceMigrations = {
//    context ->
//        listOf(SharedPreferencesMigration(context,"fileName"))
//})




class DataStoreActivity : AppCompatActivity() {


    val TAG = this.javaClass.name

    val dataStoreKey = stringPreferencesKey("key1")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_store)






    }

    suspend fun onAddClick(v : View){

        getDataStore().edit {
            it[dataStoreKey] = "name"
            it[intPreferencesKey("key2")] = 50
        }

    }
    fun onShowClick(v : View){

        val  key1 = getDataStore().data.map {
            it[dataStoreKey]
        }.catch {
            exception ->
            if (exception is IOException){
                emit(emptyPreferences().toString())
            }
            Log.e(TAG,exception.message.toString())
        }

        val  key2 = getDataStore().data.map {
            it[intPreferencesKey("key2")]
        }

        findViewById<TextView>(R.id.tv_content).text = String.format("%s--%d",key1,key2)

    }



    fun getDataStore() : DataStore<Preferences>{
        return dataStore
    }

}