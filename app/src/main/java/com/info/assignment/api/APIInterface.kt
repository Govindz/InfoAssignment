package com.info.assignment.api

import com.info.assignment.model.DataResponse

import retrofit2.Call
import retrofit2.http.GET

interface APIInterface {

    @get:GET("s/2iodh4vg0eortkl/facts.json")
    val data: Call<DataResponse>
}