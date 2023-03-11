package com.charlye934.jetpackcomposecatalogo

import androidx.compose.material.Switch
import androidx.compose.material.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Preview(showBackground = true)
@Composable
fun MySwitch() {
    var state by rememberSaveable { mutableStateOf(true) }

    Switch(checked = state, onCheckedChange = { state = !state }, colors = SwitchDefaults.colors(
        uncheckedThumbColor = Color.Red,
        checkedThumbColor = Color.Green,
        uncheckedTrackColor = Color.Magenta,
        checkedTrackColor = Color.Cyan
    ))
}