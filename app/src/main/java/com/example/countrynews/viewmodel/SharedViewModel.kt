package com.example.countrynews.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {

    var countryName = MutableLiveData<String>()



    private val _countryName = MutableLiveData<String>()

    fun setData(countryName: String) {
        _countryName.value = countryName
    }

    fun getData(): LiveData<String> = _countryName

}