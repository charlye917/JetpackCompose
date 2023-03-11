package com.charlye934.jetpackcomposecatalogo

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MyComplexLayout() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color.Cyan),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Ejemplo 1")
        }
        Spacer(modifier = Modifier.height(30.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color.Red),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Ejemplo 2")
            }
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color.Green),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Ejemplo 3")
            }
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color.Magenta),
            contentAlignment = Alignment.BottomCenter
        ) {
            Text(text = "Ejemplo 4")
        }
    }
}

@Composable
fun MyRow() {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .horizontalScroll(rememberScrollState()),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = "Ejemplo 1", modifier = Modifier.background(Color.Blue))
        Text(text = "Ejemplo 2", modifier = Modifier.background(Color.Red))
        Text(text = "Ejemplo 3", modifier = Modifier.background(Color.Gray))
        Text(text = "Ejemplo 4", modifier = Modifier.background(Color.Green))
        Text(text = "Ejemplo 5", modifier = Modifier.background(Color.Cyan))
    }
}

@Composable
fun MyColumn() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = "Ejemplo 1", modifier = Modifier.background(Color.Blue))
        Text(text = "Ejemplo 2", modifier = Modifier.background(Color.Red))
        Text(text = "Ejemplo 3", modifier = Modifier.background(Color.Gray))
        Text(text = "Ejemplo 4", modifier = Modifier.background(Color.Green))
        Text(text = "Ejemplo 5", modifier = Modifier.background(Color.Cyan))
    }
}

@Composable
fun MyBox() {
    Box(
        modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Cyan)
                .verticalScroll(rememberScrollState()), contentAlignment = Alignment.Center
        ) {
            Text(text = "Esto es un ejemplo")
        }
    }
}

@Composable
fun MyStateExaple() {

    var counter by rememberSaveable{ mutableStateOf(0) }
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { counter += 1 }) {
            Text(text = "Pulsar")
        }

        Text(text = "He sido pulsado $counter veces")
    }
}