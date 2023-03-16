package com.charlye934.jetpackcomposecatalogo

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.charlye934.jetpackcomposecatalogo.data.CheckInfo

@Composable
fun MySwitch() {
    var state by rememberSaveable { mutableStateOf(true) }

    Switch(
        checked = state, onCheckedChange = { state = !state },
        colors = SwitchDefaults.colors(
            uncheckedThumbColor = Color.Red,
            checkedThumbColor = Color.Green,
            uncheckedTrackColor = Color.Magenta,
            checkedTrackColor = Color.Cyan,
            checkedTrackAlpha = 0.1f,
            uncheckedTrackAlpha = 0.1f,
            disabledCheckedTrackColor = Color.Yellow,
            disabledCheckedThumbColor = Color.Yellow
        )
    )
}

@Composable
fun MyCheckBox() {
    var state by rememberSaveable { mutableStateOf(false) }
    Checkbox(
        checked = state, onCheckedChange = { state = !state },
        enabled = true,
        colors = CheckboxDefaults.colors(
            checkedColor = Color.Red,
            uncheckedColor = Color.Yellow,
            checkmarkColor = Color.Blue
        )
    )
}

@Preview(showBackground = true)
@Composable
fun MyCheckBoxWithText(){
    var state by rememberSaveable { mutableStateOf(false) }
    
    Row(modifier = Modifier.padding(8.dp)) {
        Checkbox(checked = state, onCheckedChange = {state = !state})
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = "Ejemplo 1")
    }
}

@Composable
fun MyCheckBoxWithText(checkInfo: CheckInfo){
    Row(modifier = Modifier.padding(8.dp)) {
        Checkbox(
            checked = checkInfo.selected,
            onCheckedChange = {checkInfo.onCheckedChnage(!checkInfo.selected) }
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = checkInfo.title)
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