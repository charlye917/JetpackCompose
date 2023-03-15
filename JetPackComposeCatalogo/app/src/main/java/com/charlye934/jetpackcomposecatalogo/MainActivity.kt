package com.charlye934.jetpackcomposecatalogo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.state.ToggleableState
import com.charlye934.jetpackcomposecatalogo.data.CheckInfo
import com.charlye934.jetpackcomposecatalogo.ui.theme.JetPackComposeCatalogoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetPackComposeCatalogoTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background
                ) {
                    val myOption = GetOption(listOf("Aris", "ejemplo", "picachu"))
                    var selected by remember { mutableStateOf("Carlos") }
                    Column {
                        MyRadioButtonList(name = selected   , onItemSelected = {selected = it})
                        //MyTriStatusCheckBox()
                        //myOption.forEach { MyCheckBoxWithText(it) }
                    }
                }
            }
        }
    }
}

@Composable
fun MyRadioButton(){
    Row() {
        RadioButton(
            selected = false,
            onClick = { },
            colors = RadioButtonDefaults.colors(
                selectedColor = Color.Red,
                unselectedColor = Color.Yellow,
                disabledColor = Color.Green
            )
        )
        Text(text = "Ejemplo 1")
    }
}

@Composable
fun MyRadioButtonList(name: String, onItemSelected: (String) -> Unit){
    var selected by remember{ mutableStateOf("Carlos")}
    Column(Modifier.fillMaxWidth()) {
        Row(Modifier.fillMaxWidth()) {
            RadioButton(selected = name == "Carlos", onClick = { onItemSelected("Carlos") })
            Text(text = "Carlos")
        }
        Row(Modifier.fillMaxWidth()) {
            RadioButton(selected = name == "Alberto", onClick = { onItemSelected("Alberto") })
            Text(text = "Alberto")
        }
        Row(Modifier.fillMaxWidth()) {
            RadioButton(selected = name == "Arteaga", onClick = { onItemSelected("Arteaga") })
            Text(text = "Arteaga")
        }
        Row(Modifier.fillMaxWidth()) {
            RadioButton(selected = name == "Lira", onClick = { onItemSelected("Lira") })
            Text(text = "Lira")
        }
    }
}

@Composable
fun MyTriStatusCheckBox(){
    var status by rememberSaveable { mutableStateOf(ToggleableState.Off) }
    TriStateCheckbox(state = status, onClick = {
        status = when(status){
            ToggleableState.On -> { ToggleableState.Off}
            ToggleableState.Off -> { ToggleableState.Indeterminate }
            ToggleableState.Indeterminate -> { ToggleableState.On }
        }
    })
}

@Composable
fun GetOption(title: List<String>): List<CheckInfo>{
    return title.map {
        var status by rememberSaveable { mutableStateOf(false) }
        CheckInfo(
            title = it,
            selected = status,
            onCheckedChnage = { myNewStatus -> status = myNewStatus }
        )
    }
}
@Preview(showBackground = true, device = Devices.NEXUS_5)
@Composable
fun DefaultPreview() {
    JetPackComposeCatalogoTheme {
        MyButton()
    }
}