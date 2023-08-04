package com.example.myapplication.data.remote

import com.example.myapplication.data.models.ProductResponse
import retrofit2.Response
import retrofit2.http.GET

interface ProductsService {
    @GET("products")
    suspend fun getProducts() : Response<ProductResponse>
}