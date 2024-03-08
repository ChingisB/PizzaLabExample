package com.example.dodopizza.data


sealed interface Product{
    val imageRes: Int
    val name: String
    val description: String
    val price: String
}

data class Pizza(
    override val imageRes: Int,
    override val name: String,
    override val price: String,
    override val description: String
): Product


data class Combo(
    override val imageRes: Int,
    override val name: String,
    override val price: String,
    override val description: String
): Product