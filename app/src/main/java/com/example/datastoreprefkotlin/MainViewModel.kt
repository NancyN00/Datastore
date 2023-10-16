package com.example.datastoreprefkotlin

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

//used to store and retrieve getTheme and set value from datastore

class MainViewModel(application: Application) : AndroidViewModel(application) {

    val dataStore = DataStoreManager(application)

    val getTheme = dataStore.getTheme().asLiveData(Dispatchers.IO)

    //get to access the fun inside DataStoreManager
    fun setTheme(isDarkMode : Boolean){
        viewModelScope.launch {
            dataStore.setTheme(isDarkMode)
        }
    }

}