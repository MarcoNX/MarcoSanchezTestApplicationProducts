package com.example.myapplication.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.models.Products
import com.example.myapplication.domain.usecase.GetProductUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(
    val getProductuseCase: GetProductUseCase
        ):ViewModel(){
    private val _products = MutableLiveData<List<Products>>()
    val products : LiveData<List<Products>> = _products

    fun getProducts(){
        viewModelScope.launch {
            val result = getProductuseCase.invoke()
            if(result.code == 200){
                if(result.response.products.isNullOrEmpty()){
                    //TODO MANAGE EMPTY
                }else {
                    _products.postValue(result.response.products)
                }
            }else{
                //TODO MANAGE ERROR
            }
        }
    }
}