package com.charlye934.jetpackcomposecatalogo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.charlye934.jetpackcomposecatalogo.ui.theme.JetPackComposeCatalogoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetPackComposeCatalogoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background
                ) {
                    /*var myText by remember { mutableStateOf("") }
                    Column() {
                        MyOutlineTextField(myText) { myText = it }
                    }*/
                    MyButton()
                }
            }
        }
    }
}

@Preview(showBackground = true, device = Devices.NEXUS_5)
@Composable
fun DefaultPreview() {
    JetPackComposeCatalogoTheme {
        MyButton()
    }
}