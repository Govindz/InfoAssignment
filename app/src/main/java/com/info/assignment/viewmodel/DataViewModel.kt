package com.info.assignment.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.info.assignment.model.DataResponse
import com.info.assignment.repository.DataRepository

/* *
* ViewModel Class for attaching a model object to view
* */
class DataViewModel : ViewModel() {
    // Implement the ViewModel
    var data: MutableLiveData<DataResponse>? = null
        private set
    private val dataModel: DataRepository = DataRepository()

    fun init() {
        if (this.data != null) {
            // ViewModel is created per Fragment so we know the Id won't change
            return
        }
        data = dataModel.model
    }
}