package com.example.myapplication.data.repository

import com.example.myapplication.data.models.ProductResponse
import com.example.myapplication.data.models.ProductResult
import com.example.myapplication.data.remote.ProductsService
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.security.auth.login.LoginException

class ProductRepository @Inject constructor(val service: ProductsService){
    suspend fun callServiceGetProducts():ProductResult{
        return withContext(Dispatchers.IO){
            try {
                val response = service.getProducts()
                val productResponse: ProductResponse = if (response.isSuccessful) {
                    response.body() ?: ProductResponse()
                } else {
                    if (response.body() != null) {
                        Gson().fromJson(response.body()!!.toString(), ProductResponse::class.java)
                    } else {
                        ProductResponse()
                    }
                }
                ProductResult(code = 200, response = productResponse)
            }catch (e: Exception){
                ProductResult(500,ProductResponse())
            }
        }
    }
}