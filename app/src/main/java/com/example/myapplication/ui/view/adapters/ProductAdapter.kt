package com.example.myapplication.ui.view.adapters

import android.speech.RecognitionListener
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.data.models.Products
import com.example.myapplication.databinding.ProductItemListBinding
import com.example.myapplication.ui.view.viewholders.ProductViewHolder
import kotlin.math.sign

class ProductAdapter(val data: List<Products>, private val action: (Products)-> Unit): RecyclerView.Adapter<ProductViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding = ProductItemListBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ProductViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
            holder.bind(data[position]){action(data[position])}
    }
}