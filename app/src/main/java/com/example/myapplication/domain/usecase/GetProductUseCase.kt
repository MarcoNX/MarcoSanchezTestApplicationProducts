package com.example.myapplication.domain.usecase

import com.example.myapplication.data.models.ProductResult
import com.example.myapplication.data.repository.ProductRepository
import javax.inject.Inject

class GetProductUseCase @Inject constructor(private val repository: ProductRepository) {
    suspend operator fun invoke():ProductResult{
        return repository.callServiceGetProducts()
    }
}