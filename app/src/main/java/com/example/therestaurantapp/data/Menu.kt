package com.example.therestaurantapp.data

data class Order(
    val tableNumber: Int,
    var orderItems: MutableList<Item>
)

data class Item(
    val name : String,
    val price : String,
    var qty : Int = 0,
    val category : String
)

val rupee : String = "₹"

val Menu = listOf(
    // Tiffins
    Item(name = "Masala Dosa", price = "120", category = "Tiffins"),
    Item(name = "Plain Dosa", price = "80", category = "Tiffins"),
    Item(name = "Onion Dosa", price = "140", category = "Tiffins"),
    Item(name = "Idli", price = "60", category = "Tiffins"),
    Item(name = "Vada", price = "70", category = "Tiffins"),
    Item(name = "Podi Idli", price = "80", category = "Tiffins"),
    Item(name = "Sambar", price = "30", category = "Tiffins"),
    Item(name = "Rasam", price = "30", category = "Tiffins"),
    Item(name = "Kootu", price = "50", category = "Tiffins"),

    // Main Course
    Item(name = "Chicken Biryani", price = "200", category = "Main Course"),
    Item(name = "Mutton Biryani", price = "250", category = "Main Course"),
    Item(name = "Vegetable Biryani", price = "200", category = "Main Course"),
    Item(name = "Vegetable Korma", price = "200", category = "Main Course"),
    Item(name = "Palak Paneer", price = "160", category = "Main Course"),
    Item(name = "Aloo Gobi", price = "140", category = "Main Course"),
    Item(name = "Baingan Bharta", price = "130", category = "Main Course"),
    Item(name = "Mushroom Masala", price = "160", category = "Main Course"),

    // Beverages
    Item(name = "Filter Coffee", price = "30", category = "Beverages"),
    Item(name = "Masala Chai", price = "30", category = "Beverages"),
    Item(name = "Lassi", price = "50", category = "Beverages"),
    Item(name = "Buttermilk", price = "30", category = "Beverages"),
    Item(name = "Fresh Lime Soda", price = "40", category = "Beverages"),
    Item(name = "Mango Lassi", price = "50", category = "Beverages"),
    Item(name = "Sugarcane Juice", price = "40", category = "Beverages"),
    Item(name = "Badam Milk", price = "60", category = "Beverages"),

    // Desserts
    Item(name = "Payasam", price = "70", category = "Desserts"),
    Item(name = "Kesari", price = "60", category = "Desserts"),
    Item(name = "Gulab Jamun", price = "80", category = "Desserts"),
    Item(name = "Paan Ice Cream", price = "100", category = "Desserts"),
    Item(name = "Mango Kulfi", price = "80", category = "Desserts"),
    Item(name = "Rasgulla", price = "60", category = "Desserts"),
    Item(name = "Jalebi", price = "50", category = "Desserts"),
    Item(name = "Fruit Salad", price = "70", category = "Desserts"),
)
