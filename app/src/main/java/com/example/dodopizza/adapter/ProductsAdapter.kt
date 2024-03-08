package com.example.dodopizza.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.dodopizza.data.Combo
import com.example.dodopizza.data.Pizza
import com.example.dodopizza.data.Product
import com.example.dodopizza.databinding.LayoutItemComboBinding
import com.example.dodopizza.databinding.LayoutItemPizzaBinding

class ProductsAdapter(private val callback: ItemCallback) :
    ListAdapter<Product, ProductsAdapter.ViewHolder>(ProductDiffUtil) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            PIZZA_VIEW_TYPE ->
                PizzaViewHolder(LayoutItemPizzaBinding.inflate(inflater, parent, false))

            else -> ComboViewHolder(LayoutItemComboBinding.inflate(inflater, parent, false))
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        currentList.get(position).let(holder::bind)
    }

    override fun getItemViewType(position: Int): Int = when (currentList[position]) {
        is Pizza -> PIZZA_VIEW_TYPE
        is Combo -> COMBO_VIEW_TYPE
    }


    abstract class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        abstract fun bind(item: Product)
    }

    inner class PizzaViewHolder(private val binding: LayoutItemPizzaBinding) :
        ViewHolder(binding.root) {

        override fun bind(item: Product) = with(binding) {
            root.setOnClickListener { callback.onItemClick(item) }
            pizzaImageView.setImageResource(item.imageRes)
            pizzaNameTextView.text = item.name
            pizzaDescriptionTextView.text = item.description
            pizzaBuyButton.text = item.price
        }
    }

    inner class ComboViewHolder(private val binding: LayoutItemComboBinding) :
        ViewHolder(binding.root) {
        override fun bind(item: Product) = with(binding) {
            root.setOnClickListener { callback.onItemClick(item) }
            pizzaImageView.setImageResource(item.imageRes)
            pizzaNameTextView.text = item.name
            pizzaDescriptionTextView.text = item.description
            pizzaBuyButton.text = item.price
        }
    }

    fun interface ItemCallback {
        fun onItemClick(item: Product)
    }


    companion object {
        private const val PIZZA_VIEW_TYPE = 0
        private const val COMBO_VIEW_TYPE = 1
    }
}


object ProductDiffUtil : DiffUtil.ItemCallback<Product>() {
    override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
        return oldItem == newItem
    }

    override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
        return oldItem.javaClass == newItem.javaClass && oldItem.name == newItem.name
    }
}