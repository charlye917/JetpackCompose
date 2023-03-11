package com.charlye934.jetpackcomposecatalogo

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Star
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp

@Composable
fun MyText() {
    Column(Modifier.fillMaxSize()) {
        Text(text = "Esto es un ejemplo")
        Text(text = "Esto es un ejemplo", color = Color.Green)
        Text(text = "Esto es un ejemplo", fontWeight = FontWeight.Light)
        Text(text = "Esto es un ejemplo", fontFamily = FontFamily.Cursive)
        Text(
            text = "Esto es un ejemplo", textDecoration = TextDecoration.LineThrough
        )
        Text(
            text = "Esto es un ejemplo", textDecoration = TextDecoration.Underline
        )
        Text(
            text = "Esto es un ejemplo", textDecoration = TextDecoration.combine(
                listOf(
                    TextDecoration.Underline, TextDecoration.LineThrough
                )
            )
        )
    }
}

@Composable
fun MyTextFiedl(myText: String, onValueChange: (String) -> Unit) {
    TextField(value = myText, onValueChange = onValueChange)
}

@Composable
fun MyTextFieldAdvance(myText: String, onValueChange: (String) -> Unit) {
    //onValueChange = { myText = if (it.contains("!")) it.replace("!", "") else it
    TextField(value = myText,
        onValueChange = { onValueChange },
        label = { Text(text = "Introduce tu nombre") })
}

@Composable
fun MyOutlineTextField(myText: String, onValueChange: (String) -> Unit) {
    OutlinedTextField(
        value = myText,
        onValueChange = onValueChange,
        modifier = Modifier.padding(24.dp),
        label = { Text(text = "Introduce tu nombre") },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Magenta,
            unfocusedBorderColor = Color.Blue
        )
    )
}

@Composable
fun MyButton() {
    var enable by rememberSaveable { mutableStateOf(true) }
    Column(
        Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Button(
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Magenta,
                contentColor = Color.Blue
            ),
            enabled = enable,
            border = BorderStroke(5.dp, Color.Green),
            onClick = { enable = false }
        ) {
            Text(text = "Vamos")
        }

        OutlinedButton(
            modifier = Modifier.padding(top = 8.dp),
            enabled = enable,
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Magenta,
                contentColor = Color.Blue
            ),
            onClick = { /*TODO*/ }
        ) {
            Text(text = "Enter")
        }

        TextButton(onClick = { }) {
            Text(text = "Text Button")
        }
    }
}

