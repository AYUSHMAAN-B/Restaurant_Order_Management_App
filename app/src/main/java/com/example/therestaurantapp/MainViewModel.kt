package com.example.therestaurantapp

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.therestaurantapp.data.Item
import com.example.therestaurantapp.data.Menu
import com.example.therestaurantapp.data.Order

class MenuViewModel : ViewModel()
{
    val groupedMenu: Map<String, List<Item>> = Menu.groupBy { it.category }

    val tiffins = groupedMenu["Tiffins"] ?: emptyList()
    val mainCourse = groupedMenu["Main Course"] ?: emptyList()
    val beverages = groupedMenu["Beverages"] ?: emptyList()
    val desserts = groupedMenu["Desserts"] ?: emptyList()

    var Table_1 : Order = Order(1, mutableListOf())
    var Table_2 : Order = Order(2, mutableListOf())
    var Table_3 : Order = Order(3, mutableListOf())
    var Table_4 : Order = Order(4, mutableListOf())
    var Table_5 : Order = Order(5, mutableListOf())
    var Table_6 : Order = Order(6, mutableListOf())
    var Table_7 : Order = Order(7, mutableListOf())
    var Table_8 : Order = Order(8, mutableListOf())

    fun Order(table : Int)
    {
        val all = tiffins + mainCourse + beverages + desserts

        when(table)
        {
            1 -> {
                    all.forEach {
                        if( it.qty > 0 )
                            Table_1.orderItems.add(it.copy())
                    }

                Log.d("Order", " ${Table_1.orderItems.size} Orders placed for table $table")

                Table_1.orderItems.forEach {
                    if (it.qty > 0)
                        Log.d("Order", "Item: ${it.name} Qty: ${it.qty}")
                }
            }
            2 -> {
                    all.forEach {
                        if( it.qty > 0 )
                            Table_2.orderItems.add(it.copy())
                    }

                Log.d("Order", " ${Table_2.orderItems.size} Orders placed for table $table")
            }
            3 -> {
                    all.forEach {
                        if( it.qty > 0 )
                            Table_3.orderItems.add(it.copy())
                    }

                Log.d("Order", " ${Table_3.orderItems.size} Orders placed for table $table")
            }
            4 -> {
                    all.forEach {
                        if( it.qty > 0 )
                            Table_4.orderItems.add(it.copy())
                    }
            }
            5 -> {
                    all.forEach {
                        if( it.qty > 0 )
                            Table_5.orderItems.add(it.copy())
                    }
            }
            6 -> {
                    all.forEach {
                        if( it.qty > 0 )
                            Table_6.orderItems.add(it.copy())
                    }
            }
            7 -> {
                    all.forEach {
                        if( it.qty > 0 )
                            Table_7.orderItems.add(it.copy())
                    }
            }
            8 -> {
                    all.forEach {
                        if( it.qty > 0 )
                            Table_8.orderItems.add(it.copy())
                    }
            }
        }

        Log.d("Outside Order", " ${Table_1.orderItems.size} Orders placed for table $table")

        Table_1.orderItems.forEach {
            if (it.qty > 0)
                Log.d("Outside", "Item: ${it.name} Qty: ${it.qty}")
        }

        tiffins.forEach {
            if (it.qty > 0)
                it.qty = 0
        }

        Log.d("After Tiffins", "Before MainCourse")

        mainCourse.forEach {
            if (it.qty > 0)
                it.qty = 0
        }

        Log.d("After MainCourse", "Before Beverages")

        beverages.forEach {
            if (it.qty > 0)
                it.qty = 0
        }

        Log.d("After Beverages", "Before Desserts")

        desserts.forEach {
            if (it.qty > 0)
                it.qty = 0
        }

        Table_1.orderItems.forEach {
            if (it.qty > 0)
                Log.d("Outside When", "Item: ${it.name} Qty: ${it.qty}")
            else
                Log.d("Empty", "Empty")
        }
    }

    fun displayItems(table:Int) : List<Item>
    {
        val returnList : MutableList<Item> ?= null

        when(table)
        {
            1 -> return Table_1.orderItems
            2 -> return Table_2.orderItems
            3 -> return Table_3.orderItems
            4 -> return Table_4.orderItems
            5 -> return Table_5.orderItems
            6 -> return Table_6.orderItems
            7 -> return Table_7.orderItems
            8 -> return Table_8.orderItems
        }

        return returnList ?: emptyList()
    }

    fun ClearOrder(table : Int)
    {
        when(table)
        {
            1 -> Table_1.orderItems.clear()
            2 -> Table_2.orderItems.clear()
            3 -> Table_3.orderItems.clear()
            4 -> Table_4.orderItems.clear()
            5 -> Table_5.orderItems.clear()
            6 -> Table_6.orderItems.clear()
            7 -> Table_7.orderItems.clear()
            8 -> Table_8.orderItems.clear()
        }
    }
}
