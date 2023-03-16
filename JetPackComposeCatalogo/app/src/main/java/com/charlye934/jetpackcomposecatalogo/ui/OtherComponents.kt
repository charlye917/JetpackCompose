package com.charlye934.jetpackcomposecatalogo.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MyCard(){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = 12.dp,
        shape = MaterialTheme.shapes.medium,
        backgroundColor = Color.Red,
        contentColor = Color.Green,
        border = BorderStroke(5.dp, Color.Green)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Ejemplo 1")
            Text(text = "Ejemplo 2")
            Text(text = "Ejemplo 3")
        }

    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MyBadgeBox(){
    BadgedBox(
        modifier = Modifier.padding(16.dp),
        badge = { Text(text = "1")}
    ) {
        Icon(imageVector = Icons.Default.Star, contentDescription = "")
    }
}

@Composable
fun MyDivider(){
    Divider(
        Modifier
            .fillMaxWidth()
            .padding(16.dp),
        color = Color.Yellow
    )
}

@Composable
fun MyDropDownMenu(){
    var selectedText by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }
    val dessert = listOf("Helado", "Cafe", "Chocolate", "Fruta", "Chilaquiles")

    Column(
        modifier = Modifier.padding(20.dp)
    ) {
        OutlinedTextField(
            value = selectedText,
            onValueChange = { selectedText = it},
            enabled = false,
            readOnly = true,
            modifier = Modifier
                .clickable { expanded = true }
                .fillMaxWidth()
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.fillMaxWidth()
        ) {
            dessert.forEach { dessert ->
                DropdownMenuItem(
                    onClick = {
                        expanded = false
                        selectedText = dessert
                    }) {
                        Text(text = dessert)
                    }
            }

        }
    }
}