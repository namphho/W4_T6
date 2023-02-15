package com.watasolutions.w4_t6

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.watasolutions.w4_t6.model.Image
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainVM : ViewModel() {
    private var _listOfIdol: MutableLiveData<List<Image>> = MutableLiveData()
    val listOfIdol: LiveData<List<Image>>
        get() = _listOfIdol

    private var _isLoading: MutableLiveData<Boolean> = MutableLiveData()
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    fun loadData() {
        _isLoading.postValue(true)

        viewModelScope.launch {
            delay(3000)
            val dataSet = DataStore.getDataSet()

            _isLoading.postValue(false)
            _listOfIdol.postValue(dataSet)
        }


    }
}