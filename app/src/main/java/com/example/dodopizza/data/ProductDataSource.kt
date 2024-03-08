package com.example.dodopizza.data

import com.example.dodopizza.R


object ProductDataSource {

    val originalList
        get() =
            listOf(
                Pizza(
                    imageRes = R.drawable.image_pizza_cheese,
                    name = "Сырная пицца",
                    description = "Моцарелла, сыры чеддер\n и пармезан, соус альфредо",
                    price = "от 1 900 тг."
                ),

                Pizza(
                    imageRes = R.drawable.image_pizza_diablo,
                    name = "Диабло",
                    description = "Острая чоризо, острый перец халапеньо,\n соус барбекю, митболы из говядины, \nтоматы, сладкий перец, красный лук,\n моцарелла, томатный соус",
                    price = "от 2 900 тг."
                ),

                Combo(
                    imageRes = R.drawable.image_box,
                    name = "Фиксики Бокс",
                    description = "Коробочка, в которой живет Фиксик! Две закуски, напиток и игрушка с героем мультфильма на выбор",
                    price = "2 500 тг."
                ),

                Pizza(
                    imageRes = R.drawable.image_pizza_chicken,
                    name = "Двойной цыпленок",
                    description = "Цыпленок, моцарелла, соус альфредо",
                    price = "от 2 100 тг."
                ),

                Combo(
                    imageRes = R.drawable.image_combo,
                    name = "Комбо от Смешариков",
                    description = "Одобрено героями мультфильма: маленькая\n пицца любого вкуса и набор юного\n садовода. Цена комбо зависит от\n выбранных пицц и может быть увеличена",
                    price = "2 300 тг."
                ),

                Pizza(
                    imageRes = R.drawable.image_pizza_pepperoni,
                    name = "Пепперони фреш",
                    description = "Пикантная пепперони, мно-о-ого моцареллы, томаты и томатный соус",
                    price = "от 2 000 тг."
                ),

                Pizza(
                    imageRes = R.drawable.image_pizza_pineapple,
                    name = "Гавайская с альфредо",
                    description = "Двойная порция цыпленка, кусочки\n ананасов, моцарелла, соус альфредо",
                    price = "от 2 500 тг."
                )
            )

    fun getFilteredList(text: String): List<Product>{
        return originalList.filter {
            it.name.contains(text, true) || text.contains(it.name, true) || it.description.contains(text, true) || text.contains(it.description, true)
        }
    }
}