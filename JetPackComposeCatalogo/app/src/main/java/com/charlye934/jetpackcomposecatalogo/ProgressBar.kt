package com.charlye934.jetpackcomposecatalogo

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue


@Preview(showBackground = true, device = Devices.NEXUS_5)
@Composable
fun MyProgressAdvance() {

    var state by rememberSaveable { mutableStateOf(0f) }

    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator(progress = 0.5f)
        Row(
           Modifier.fillMaxWidth()
        ){
            Button(onClick = { state += 0.1f }) {
                Text(text = "Incremental")
            }
            Button(onClick = { state -= 0.1f }) {
                Text(text = "Reducir")
            }
        }
    }
}

@Composable
fun MyProgress() {
    var showLoading by rememberSaveable { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .padding(24.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (showLoading) {
            CircularProgressIndicator(color = Color.Red)
            LinearProgressIndicator(
                modifier = Modifier.padding(top = 32.dp),
                color = Color.Red,
                backgroundColor = Color.Green
            )
        }
        Button(onClick = { showLoading = !showLoading }) {
            Text(text = "Cargo perfil")
        }
    }
}
