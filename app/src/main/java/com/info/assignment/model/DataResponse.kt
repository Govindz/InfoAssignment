package com.info.assignment.model

import com.google.gson.annotations.SerializedName

/*
* Get API Object of list and Title of header toolbar*/
class DataResponse {

    @SerializedName("rows")
    lateinit var rows: List<Data>

    @SerializedName("title")
    lateinit var title: String

}