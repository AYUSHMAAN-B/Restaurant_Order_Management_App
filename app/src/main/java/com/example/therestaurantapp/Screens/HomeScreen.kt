package com.example.therestaurantapp.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.therestaurantapp.MenuViewModel

@Composable
fun HomeScreen()
{
    val cards = listOf(1, 2, 3, 4, 5, 6, 7, 8)

    val viewModel : MenuViewModel = viewModel()

    Column(
        modifier = Modifier.background(Color(0xffcad2c5))
    ) {

        Text("Welcome to The Restaurant",
            color = Color(0xff2f3e46),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .background(Color(0xffcad2c5)))

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            items(cards.size) {
                TableCard(
                    tableNumber = it + 1,
                    viewModel = viewModel)
            }
        }
    }
}

@Composable
fun TableCard(
    tableNumber: Int,
    viewModel: MenuViewModel)
{
    var occupied by remember { mutableStateOf(false) }
    var showDialog by remember { mutableStateOf(false) }
    var generateBill by remember { mutableStateOf(false) }

    var table by remember { mutableStateOf(-1) }

    Card(
        modifier = Modifier
            .padding(8.dp)
            .size(100.dp, 200.dp),
        colors = CardDefaults.cardColors(Color(0xff84a98c))
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.25f)
                    .background(Color(0xff354f52))
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.75f)
                    .align(Alignment.BottomCenter)
                    .background(Color(0xff84a98c)),
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(4.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Button(
                        onClick = {
                            table = tableNumber
                            showDialog = true },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xff52796f),
                            contentColor = Color.White)
                    ) {
                        Text(text = if( occupied ) "Order More" else "Order",
                            fontSize = 16.sp)
                    }

                    if (occupied) {
                        Button(
                            onClick = {
                                generateBill = true },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xff52796f),
                                contentColor = Color.White)
                        ) {
                            Text("Generate Bill",
                                fontSize = 16.sp)
                        }
                    }

                    Spacer(modifier = Modifier.size(12.dp))
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .align(Alignment.TopCenter),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    "Table $tableNumber",
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp
                )
            }

            if( occupied )
            {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.BottomCenter)
                        .background(Color(0xff84a98c))
                ) {
                    if (occupied)
                    {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp),
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Text("Table Occupied",)
                        }
                    }
                }
            }
        }
    }

    if( showDialog )
    {
        AlertDialog(
            onDismissRequest = {
                table = -1
                showDialog = false },
            title = { Text("Menu",
                color = Color.Black,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center)
            },
            text = { MenuScreen(
                        table = table,
                        viewModel = viewModel)
                   },
            confirmButton = {
                Button(
                    onClick = {
                        occupied = true
                        viewModel.Order(table)
                        showDialog = false },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xff52796f),
                        contentColor = Color.White)
                ) {
                    Text("Order")
                }
            },
            dismissButton = {
                Button(
                    onClick = { showDialog = false },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xff52796f),
                        contentColor = Color.White)
                ) {
                    Text("Cancel")
                }
            },
            containerColor = Color(0xffcad2c5),
            modifier = Modifier.fillMaxWidth(),
        )
    }

    if( generateBill )
    {
        AlertDialog(
            onDismissRequest = { },
            title = { Text("Bill",
                color = Color.Black,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center)
            },
            text = { BillScreen(
                        table = table,
                        viewModel = viewModel )
                   },
            confirmButton = {
                Button(
                    onClick = {
                        generateBill = false
                        occupied = false
                        viewModel.ClearOrder(table)
                        table = -1
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xff52796f),
                        contentColor = Color.White)
                ) {
                    Text("Paid")
                }
            },
            dismissButton = { },
            containerColor = Color(0xffcad2c5),
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}