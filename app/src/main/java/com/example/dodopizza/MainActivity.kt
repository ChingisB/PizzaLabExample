package com.example.dodopizza

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.dodopizza.adapter.ProductsAdapter
import com.example.dodopizza.data.Product
import com.example.dodopizza.data.ProductDataSource
import com.example.dodopizza.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val adapter = ProductsAdapter(::onItemClick)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupAdapter()
    }

    private fun setupAdapter() {
        binding.pizzaList.adapter = adapter
        adapter.submitList(ProductDataSource.originalList)
    }

    private fun setupSearchView() {
        // TODO
    }


    private fun onItemClick(item: Product) {
        Toast.makeText(this, item.name, Toast.LENGTH_SHORT).show()
    }
}