package com.example.myapplication.data.models

import com.google.gson.annotations.SerializedName

data class ProductResponse (

    @SerializedName("products" ) var products : ArrayList<Products> = arrayListOf(),
    @SerializedName("total"    ) var total    : Int?                = null,
    @SerializedName("skip"     ) var skip     : Int?                = null,
    @SerializedName("limit"    ) var limit    : Int?                = null

)