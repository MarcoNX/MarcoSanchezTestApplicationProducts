package com.example.myapplication.ui.view.viewholders

import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.data.models.Products
import com.example.myapplication.databinding.ProductItemListBinding

class ProductViewHolder(val binding: ProductItemListBinding) :RecyclerView.ViewHolder(binding.root) {
    fun bind( product:Products, action: (Products)-> Unit){
        binding.itemProductName.text = "Nombre: ${product.title}"
        binding.itemProductDescription.text = product.description
        binding.itemProductPrice.text = "Precio: ${product.price}"
        binding.itemProductCv.setOnClickListener { action(product)}
    }
}