package com.info.assignment.repository

import androidx.lifecycle.MutableLiveData
import com.info.assignment.api.APIInterface
import com.info.assignment.api.ApiClient
import com.info.assignment.model.DataResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/*
* DataRepository class for API Request call to fetch data
* */
class DataRepository {

    private var apiInterface: APIInterface? = null

    val model: MutableLiveData<DataResponse>
        get() {
            val mutableLiveData = MutableLiveData<DataResponse>()
            apiInterface = ApiClient.retrofitInstance.create(APIInterface::class.java)
            val call = apiInterface!!.data
            call.enqueue(object : Callback<DataResponse> {
                override fun onResponse(call: Call<DataResponse>, response: Response<DataResponse>) {
                    if (response.body() != null) {
                        mutableLiveData.value = response.body()
                    }
                }

                override fun onFailure(call: Call<DataResponse>, t: Throwable) {
                }
            })

            return mutableLiveData
        }
}
