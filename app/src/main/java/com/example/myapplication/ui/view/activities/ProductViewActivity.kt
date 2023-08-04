package com.example.myapplication.ui.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.myapplication.data.models.Products
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.databinding.ActivityProductViewBinding

class ProductViewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProductViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductViewBinding.inflate(layoutInflater)
        val product = intent.getSerializableExtra("product") as Products
        binding.productViewTittle.text = product.title
        binding.productViewDescription.text = product.description
        binding.productViewPrice.text = "Precio: ${product.price}"
        binding.productViewBackBtn.setOnClickListener { finish() }
        Glide.with(this).load(product.thumbnail).into(binding.productViewIv)
        setContentView(binding.root)
    }
}