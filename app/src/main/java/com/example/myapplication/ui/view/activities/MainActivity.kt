package com.example.myapplication.ui.view.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.data.models.Products
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.ui.view.adapters.ProductAdapter
import com.example.myapplication.ui.view.viewholders.ProductViewHolder
import com.example.myapplication.ui.viewmodel.ProductViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewmodel: ProductViewModel by viewModels()
    private val data = mutableListOf<Products>()
    private lateinit var adapter: ProductAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        manageView()
        observeData()
        viewmodel.getProducts()
        setContentView(binding.root)
    }

    private fun observeData() {
        viewmodel.products.observe(this){
            data.addAll(it)
            adapter.notifyDataSetChanged()
        }
    }

    private fun manageView() {
        adapter = ProductAdapter(data){onClicProduct(it)}
        binding.mainProductsRv.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        binding.mainProductsRv.adapter = adapter
    }

    private fun onClicProduct(product: Products){
        val intent = Intent(this,ProductViewActivity::class.java)
        intent.putExtra("product",product)
        startActivity(intent)
    }
}