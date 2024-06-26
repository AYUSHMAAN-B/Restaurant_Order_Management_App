package com.example.therestaurantapp.Screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults.cardColors
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.therestaurantapp.MenuViewModel
import com.example.therestaurantapp.data.Item
import com.example.therestaurantapp.data.Menu
import com.example.therestaurantapp.data.rupee

@Composable
fun MenuScreen(
    table : Int,
    viewModel : MenuViewModel
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
    ) {
        item {
            Text(
                "Tiffins",
                color = Color(0xff2f3e46),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(16.dp),
                textDecoration = TextDecoration.Underline
            )
        }

        items(viewModel.tiffins) { item ->
            MenuItemRow(item, viewModel)
        }

        item {
            Divider(modifier = Modifier.padding(top = 16.dp))
            Text(
                "Main Course",
                color = Color(0xff2f3e46),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(16.dp),
                textDecoration = TextDecoration.Underline
            )
        }

        items(viewModel.mainCourse) { item ->
            MenuItemRow(item, viewModel)
        }

        item {
            Divider(modifier = Modifier.padding(top = 16.dp))
            Text(
                "Beverages",
                color = Color(0xff2f3e46),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(16.dp),
                textDecoration = TextDecoration.Underline
            )
        }

        items(viewModel.beverages) { item ->
            MenuItemRow(item, viewModel)
        }

        item {
            Divider(modifier = Modifier.padding(top = 16.dp))
            Text(
                "Desserts",
                color = Color(0xff2f3e46),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(16.dp),
                textDecoration = TextDecoration.Underline
            )
        }

        items(viewModel.desserts) { item ->
            MenuItemRow(item, viewModel)
        }
    }
}

@Composable
fun MenuItemRow(
    item: Item,
    viewModel: MenuViewModel)
{
    var quantity by remember { mutableIntStateOf(0) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Text(item.name,
                color = Color(0xff2f3e46),
                fontSize = 20.sp)
            Text(rupee + item.price,
                color = Color(0xff2f3e46),
                fontSize = 16.sp)
        }

        Card(
            modifier = Modifier
                .height(50.dp)
                .width(100.dp),
            colors = if( quantity > 0 ) cardColors(Color(0xff2f3e46)) else cardColors(Color(0xffcad2c5)),
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("-",
                    color = if( quantity > 0 ) Color.White else Color(0xff2f3e46),
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.clickable { if(quantity > 0) {quantity--; item.qty = quantity}})

                Text(quantity.toString(),
                    color = if( quantity > 0 ) Color.White else Color(0xff2f3e46),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold)

                Text("+",
                    color = if( quantity > 0 ) Color.White else Color(0xff2f3e46),
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.clickable { quantity++; item.qty = quantity })
            }
        }
    }
}